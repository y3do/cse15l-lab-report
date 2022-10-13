# Part 1: Search Engine
Last week I was able to make a simple search engine that had commands!



Here is the list of commands that I've made. All of these commands start from the handleRequest() method which gets the URL of the localhost. Then, if methods are implemented to test for certain arguments that reside after the localhost domain:

## Add command
![](Pasted%20image%2020221012180352.png)
- This code uses the url.getPath() method to check the path of the URL to see whether it includes the string "add."
- It also uses the getQuery() method to get the query of the link. 
- The getQuery() method is in tandem with the split() method to check whether there is an s at the start of the query (I use the s as a placeholder to allow for adding the string, by using the equals() method ). That's the left side, and the right side of the split() method is used to add the string.
- The equals() method checks to see if the string (placeholder s) is in the query. 
- Finally, the if block of the getPath method (the one that checks add) returns the string "parameters[1] (representing the added string) added."
- Throughout this if block, the saved arraylist adds the added string to its arraylist to check for valid strings.


## Query
Searching for hi in my search engine:

![](Pasted%20image%2020221012181408.png)
- Another urlPath() method is used to search for specific strings. The program searches for the string "search" in the path and uses similar methods to the add method for analyzing the search data. 
	- It uses the getQuery() method to split the strings in between the = sign
	- It then checks for the "s" at the left side 
	- Finally it analyzes the string on the right side by using the built-in contains() method to check if an arraylist contains the specific string


## 404 not found
![](Pasted%20image%2020221012190434.png)
- A possible outcome is the 404 not found error. For other values that are not checked in the url, the program returns the string "404 Not Found" to signal the user of the issue.

# Part 2 Buggy Code: 
##  Reversed Method for ArrayList
-   **Failure producing input**: Two examples of failure producing inputs are inputting 2 different values. Another example is by inputting 3 different values.
-   **Symptom**: In the first example, the second value of the first 2 values is forgotten after the loop, being replaced by the first value. In the second example, there is a "sandwich" that forms between the first and the last value, with both the first and last value matching the last value.
-   **Bug**: The bug was within the for loop at the code **i < arrayLength**.
- **Connection between symptom & bug:** The whole array was iterated through to attempt to reverse the array, but the array was not properly reversed since the values that would be changed in the second half would reflect the first values which were already changed and not the original value. A better implementation would've been to only loop through half of the array, making a temporary value to store the current value on the left, and then setting the left value to the right, and the right value to the temporary value which matched the former left value. 

## Missing StringChecker implementation with filter method for Lists
- **Failure producing input:** For this program, the one possible input would be null, and that one is a failing input.
- **Symptom:** NullPointerException, because the function filter() cannot comprehend null at this point. 
- **Bug:** The bug here is the line ****interface** StringChecker { **boolean** checkString(String s); }**.
- **Connection between symptom & bug**: Because this StringChecker is only an interface, the only possible input would be null, which would lead to a nullpointerexception. One cannot use the checkString method in the StringChecker interface because the method was only described in the interface, not implemented. A better implementation would be to implement the method in the first place!