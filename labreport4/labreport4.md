# Part 1

My chosen task was replacing all the ```start``` parameters and uses to ```base```. In order to do this, I use a command %s which works as a find and replace and takes up 19 keystrokes.

```
:%s/start/base<Enter>:wq<Enter>
```

After doing the find-and-replace command described in ```:%s/start/base```, vim says at the bottom:

```4 substitutions on 4 lines```

Finally, I save and quit my files with ```:wq```: and return to the terminal output screen:

![](../other/Pasted%20image%2020221107191720.png)

The program now has all of the 
```start``` parameter and its uses into ```base```.

# Part 2

It took me 76 seconds to make edits in the first style, and 40 seconds to make edits in the second style. One difficulty that emerged when doing the edits in the first style were that I was struggling to keep track of where I was because of my transition from client to remote. 

Overall, if I had to choose which style to pick when I know I will be running the program remotely, I'd choose the first one, even though it took longer to do the entire process, because I am able to edit the file using an IDE of my choosing instead of being constrained to vim.

One thing that would factor in my decision to start from the remote with the file or start from the client and scp the file into the remote would be whether the edits I need to make to the project are large or small. If the edits are many, perhaps the file is better off being on my computer instead of the remote because instead of using vim, I am able to use an IDE to make more changes to the file. Then I can copy the file to the remote to let others view my code. In the other case, if the edits I need to make are simple, then vim would be a better option due to its precision. If I were to start from the client and use an IDE to edit the small change, there is a risk of accidentally changing something in the code since I am essentially in vim's "insert" mode all the time, at least most IDEs do that. Still, I admit I am more partial to IDEs since I personally think it's relatively easy to notice an edit you've actually made.

Another factor in my decision to choose which style would be whether the project is simple or complex. For example, if I can already imagine the commands I will use to make the edits, then there's no need to use an IDE and go through the extra step of scping the file into the remote. Instead, I could just hop onto vim from the remote and create the commands necessary to make the edits, since I already know what to edit. But if the project is complex, I'd likely need the assistance of the IDE which provides more tools such as syntax highlighting and methods suggestions.