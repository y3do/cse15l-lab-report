# Lab Report 2, Week 3: Search Engines & Bugs!
## Part 1: Search Engine
Last week I was able to make a simple search engine that had commands!

Here's the code for the search engine that I created (SearchEngine.java):

```java
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler2 implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    String s = "";
    ArrayList<String> saved = new ArrayList<String>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("String: %s", s + "\n\n");
        } else if (url.getPath().equals("/increment")) {
            s += "s";
            return String.format("String incremented!");
        } 
        else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    s += (parameters[1]);
                    
                    saved.add(parameters[1]);
                    
                    return parameters[1] + " added";
                }
            }
            if (url.getPath().contains("/search")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    if (saved.contains(parameters[1])) {
                    	return parameters[1];
                    } else {
                    	return "Not found";
                    }
                }
            }
            return "404 Not Found!";
        }
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler2());
    }
}

```

Here is the list of commands that I've made. All of these commands start from the handleRequest() method which gets the URL of the localhost. Then, if methods are implemented to test for certain arguments that reside after the localhost domain:

### Add command
![](Pasted%20image%2020221012180352.png)
- This code uses the url.getPath() method to check the path of the URL to see whether it includes the string "add."
- It also uses the getQuery() method to get the query of the link. 
- The getQuery() method is in tandem with the split() method to check whether there is an s at the start of the query (I use the s as a placeholder to allow for adding the string, by using the equals() method ). That's the left side, and the right side of the split() method is used to add the string.
- The equals() method checks to see if the string (placeholder s) is in the query. 
- Finally, the if block of the getPath method (the one that checks add) returns the string "parameters[1] (representing the added string) added."
- Throughout this if block, the saved arraylist adds the added string to its arraylist to check for valid strings.


### Query
Searching for hi in my search engine:

![](Pasted%20image%2020221012181408.png)
- Another urlPath() method is used to search for specific strings. The program searches for the string "search" in the path and uses similar methods to the add method for analyzing the search data. 
	- It uses the getQuery() method to split the strings in between the = sign
	- It then checks for the "s" at the left side 
	- Finally it analyzes the string on the right side by using the built-in contains() method to check if an arraylist contains the specific string


### 404 not found
![](Pasted%20image%2020221012190434.png)
- A possible outcome is the 404 not found error. For other values that are not checked in the url, the program returns the string "404 Not Found" to signal the user of the issue.
- Because of the fact that this outcome is an outcome that encompasses most other outcomes, it has no methods involved in its result other than method handleRequest() that analyzes the url to see if the url does not match any defined cases.

## Part 2 Buggy Code: 
### Reversed Method for ArrayList
-   **Failure producing input**: Two examples of failure producing inputs are inputting 2 different values. Another example is by inputting 3 different values.
-   **Symptom**: In the first example, the second value of the first 2 values is forgotten after the loop, being replaced by the first value. In the second example, there is a "sandwich" that forms between the first and the last value, with both the first and last value matching the last value.
-   **Bug**: The bug was within the for loop at the code **i < arrayLength**.
- **Connection between symptom & bug:** The whole array was iterated through to attempt to reverse the array, but the array was not properly reversed since the values that would be changed in the second half would reflect the first values which were already changed and not the original value. A better implementation would've been to only loop through half of the array, making a temporary value to store the current value on the left, and then setting the left value to the right, and the right value to the temporary value which matched the former left value. 

### Filter Method for List
- **Failure producing input:** The example of a failure producing input would be inputting more than one string that is valid for the code that you choose to implement for StringChecker.
- **Symptom:** Although the method claims to add filtered/valid strings in the order they appeared in the input list, this is not the case. The filter method removes the invaild methods from the list, but returns the valid elements in the opposite order!
	- For example, look at the original input versus expected input in this junit test:
		- ![](../Pasted%20image%2020221027101442.png)
		- Here's a snippet of my original vs expected lists in this test for reference (no and noo are invalid for my StringChecker implementation which validifies strings longer than 4 characters):
			- ![](../Pasted%20image%2020221027102322.png)
			- ![](../Pasted%20image%2020221027102332.png)
		- Basically, the filter did its job by removing extraneous elements, but the order of the valid elements is reversed.
- **Bug:** The bug here is this code block: 
	- ![](../Pasted%20image%2020221027101559.png)
- **Connection between symptom & bug**: Since the filter method loops from the beginning of the list, but brings every valid string to the 0th index (which bumps the values at that index up a level based on the java documentation), the order of the list is reversed. In essence this is the same thing as a **prepend** method which uses the same functionality. The easiest way to fix this implementation would be to simply remove the **first parameter** in the line **result.add(0, s).** So instead, the code would simply be **result.add(s)**. This would allow the valid values to be placed in the correct order. 