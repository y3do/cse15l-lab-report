# Lab Report 5: My Code

Here's my grading script for this lab report. It's quite a minimalistic, sequential script that goes over each requirement line by line with if statements. If one requirement fails, the script will fail the entire code and suggest changes in order to aid the student into what they have to fix. If all requirements pass, the entire code passes. 


```bash
set -e # Check for errors
rm -rf student-submission # Remove any existing student submission file that was previously graded
git clone $1 student-submission # Clone new student submission file accepting 1 parameter (Github link)
cd student-submission # Change directory to the new student submission folder

# Check if ListExamples exist in student submission home folder. If not, fail the student.
if [[ -e ListExamples.java ]]
	then 
		echo "ListExamples.java successfully found!"
	else
		echo "ListExamples.java not found :("
		echo "FAILED - ListExamples.java not found. Did you make sure it was in the correct directory?"
		exit 0
fi

set +e # Allow for errors to keep the code running, which allows for feedback through echo

# Return to parent dir, copy & compile lib hamcrest & junit jars at student-submission
cd .. 
cp -r lib student-submission
cp TestListExamples.java student-submission
javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar */*.java

# Check if student passed previous portion. If not, fail the student.
if [[ $? -eq 0 ]]
	then echo "Successful compilation!"
	else
		echo "Failed compilation :("
		echo "FAILED - Failed compilation. Check for syntax errors within your code."
		exit 0
fi

# Return to student-submission, allow for terminal to continue after errors to let terminal output pass/fail grade
cd student-submission

# Run the tests for student submission
java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples

if [[ $? -eq 0 ]]
	then echo "Successful running!"
	else
		echo "Failed running :("
		echo "FAILED - Failed running - check for errors in your code."
		exit 0 
fi

# If student passed all these tests, their code passes the grade script
echo "PASSED: Your code is adequate!"
exit 1 # Successful exit
```

# Screenshots of grading script in action

Here are some screenshots of my grading scripts in action. Note that my grading script uses a Pass/Fail grading system, so there is no need to report a percentage. 

## Screenshot 1: Perfect Repo
![](../Pasted%20image%2020221120090517.png)

## Screenshot 2: Compile Error
![](../Pasted%20image%2020221120090950.png)

## Screenshot 3: ListExamples.java exists, but is in the wrong directory
![](../Pasted%20image%2020221120091043.png)

# Trace of Compilation Error in Screenshot 2

Here's the trace of the compilation error my grading script gives in screenshot 2. 
