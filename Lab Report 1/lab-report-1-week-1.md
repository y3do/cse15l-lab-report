# Lab report, week 1: Lab Tutorial!

## Step 1: Meet your group
- I have met my group already, and you will likely also have a group because that's what programmers like doing. 
- My group is the duck squad. I enjoy being part of this group because of their unique cooking utensil tastes.
- ![DuckSquad](DuckSquad.png)

## Step 2: Your CSE15L account
- You will have an account associated with your login. Here's the account location: [Your course-specific accounts](https://sdacs.ucsd.edu/~icc/index.php)
- For help on setting your password to get ready for the authentication process to the remote server later on, here's the link: [Resetting your password](https://docs.google.com/document/d/1hs7CyQeh-MdUfM9uv99i8tqfneos6Y8bDU0uhn1wqho/edit)
- ![Login](login.png)

## Step 3: Install visual studio code
- This is quite simple. Go to the [visual studio code site](https://code.visualstudio.com/) and install the software. Pick your correct version, but you might not be able to install the software on a tablet or chromebook. Ask the TA's for help.
- When the software is installed, the homepage should look like this: [homepage.jpg]()
- Take a screenshot afterwards.
- ![VSCode](vscode.png)

## Step 4: Remotely connecting
- Before beginning this step, check to see if your OS is Windows. If not, you're fine. If you are on windows though, there is an extra step: [Install OpenSSH for Windows (not the client, not the server)](https://learn.microsoft.com/en-us/windows-server/administration/openssh/openssh_install_firstuse?tabs=gui). 
- On the terminal in either visual studio or your native device, type in ```ssh cs15lfa22zz@ieng6.ucsd.edu``` and replace the ```zz``` with your specific student name for the course.
- You can find your cse 15l-specific course username at [this link](https://sdacs.ucsd.edu/~icc/index.php) after typing in your UCSD account credentials.
- Afterwards, the system will prompt you to agree to connect, since this connection is the first time. Type "yes" then type your password to the course-specific account.
- ![terminal](terminal.png) 
- Afterwards, the system will prompt you to verify the authenticity of the host. Type yes, give your password, and you should get a message that starts with "Now on remote server." Congratulations! You've entered the remote server on one of the UCSD computers in the CSE basement.

## Step 5: Running some commands
- You can test out some commands on the remote server. Try testing out commands like ls, cd, pwd, mkdir, and cp. 
- For example, here's the result that happens when I type "ls" onto the remote server.
- ![Command](command.png)