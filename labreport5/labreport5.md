# Lab Report 5: My Script
Here's my grading script for this lab report. It's quite a minimalistic, sequential script that goes over each requirement line by line with if statements. If one requirement fails, the script will fail the entire code and suggest changes in order to aid the student into what they have to fix. If all requirements pass, the entire code passes. 

```bash
set -e # Errors will shut down program.
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
		exit 1
fi

set +e # Allow for errors to keep the code running, which allows for feedback through echo  

# Return to parent dir, copy & compile lib hamcrest & junit jars at student-submission


# Dir back to copy lib to student-submission & use TestListExamples to run tests on the submission
cd .. 
cp -r lib student-submission
cp TestListExamples.java student-submission
javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar */*.java


# Check if student passed previous portion. If not, fail the student.
if [[ $? -eq 0 ]]
	then 
		echo "Successful compilation!"
	else
		echo "Failed compilation :("
		echo "FAILED - Failed compilation. Check for syntax errors within your code."
		exit 1
fi

# Return to student-submission, allow for terminal to continue after errors to let terminal output pass/fail grade
cd student-submission

# Run the tests for student submission
java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples

# Check if student passed previous portion. If not, fail the student.
if [[ $? -eq 0 ]]
	then 
		echo "Successful running!"
	else
		echo "Failed running :("
		echo "FAILED - Failed running - check for errors in your code."
	exit 1
fi

# If student passed all these tests, their code passes the grade script
echo "PASSED: Your code is adequate!"

exit 0 # Exit code 0 indicates successful running
```

# Screenshots of grading script in action

Here are some screenshots of my grading scripts in action. **Note that my grading script uses a Pass/Fail grading system, so there is no need to report a percentage in my script's case.** 

## Screenshot 1: Perfect Repo
![](Pasted%20image%2020221120090517.png)

## Screenshot 2: Compile Error
![](Pasted%20image%2020221120090950.png)

## Screenshot 3: ListExamples.java exists, but is in the wrong directory
![](Pasted%20image%2020221120091043.png)

# Trace of Compilation Error for Program in Screenshot 2

Here's the trace of the compilation error my grading script gives in screenshot 2:

1. Run ```set -e```,  There is no standard-out/standard-error output in this command. The return code is 0, signifying a successful command.
2. Run ```rm -rf student-submission```. There is no stdout/sterr for this command. The return code is 0.
3. Run ```git clone $1 student-submission```. The stderr for this command is: 

```
Cloning into 'student-submission'...
``` 

There is no stdout. The return code is 0.

4. Run ```cd student-submission```. There is no stdout/stderr for this command. The return code is 0.
5. Go into the conditional ```if [[-e ListExamples.java]]``` that checks if ListExamples.java exists. The condition ends up being true for this scenario, because ListExamples.java exists directly inside the student-submission folder. Thus, the program prints to the terminal that the file is found. (The ```else``` block that indicates the file isn't found and exits with exit code 1 an error code does not run, because the file exists in the correct spot).
6. Outside of the if block, the program runs ```set +e``` which allows for errors to continue the program. There is no stdout/stderr in this command. The return code is 0, indicating a successful command run. In this particular program's case, ```set +e``` is only necessary to print out the student's grade after the compilation output.
7.  Run ```cd ..```. There is no stdout/stderr. The return code is 0.
8. Run ```cp -r lib student-submission```. There is no stdout/stderr. The return code is 0.
9. Run ```cp TestListExamples.java student-submission```. There is no stdout/stderr. The return code is 0.
10. Run ```javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar */*.java```. There is no stdout for this command. The stderr is:

```
student-submission/ListExamples.java:15: error: ';' expected
        result.add(0, s)
                        ^
1 error
```

The return code is 1, indicating a failed command.

11. ```if [[ $? -eq 0]]``` checks if the previous command has a return code of 0 or not. Since the previous command failed, the return code is nonzero, so the ```else``` block runs, noting the user of the failed compilation and that their grade is a fail.
12. Finally, the program runs ```exit 1``` which exits with a return code of 1, indicating the program has failed.