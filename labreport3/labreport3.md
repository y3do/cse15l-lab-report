# Researching Commands

## Find: My chosen command
- I chose the "find" command to test in my week 5 lab report. Overall, the asterisk is very compelling and I've noticed the capability of the tool.
- Here are the three commands that are interesting to use when doing "find" (This is from /technical):
1. ```find *```
2. ```find . -type d```
3. ```find * -size -2k```


### ```find *```
An interesting command line option that I can use is the \* command for find. One can think about this as an "alternate-ls" command in that it's similar to using "ls," but looks for the files within the directory as well, and forgets to list the directory. Overall, the asterisk has been captivating so far.

#### Example 1: Entire technical directory
Let's say I start from the working directory in /technical. When I do ```find *```, here's the output (NOTE: the ..more lines.. is not part of the output, it's just a demonstration):

```
...more lines...
biomed/1471-2210-3-1.txt
biomed/1471-2121-4-5.txt
biomed/1471-2350-2-8.txt
biomed/1471-2202-3-17.txt
biomed/1471-2407-1-13.txt
biomed/bcr605.txt
biomed/1476-069X-2-9.txt
biomed/1478-1336-1-3.txt
biomed/1471-2164-2-4.txt
biomed/1471-2210-1-3.txt
..more lines...
government/Media/The_Bend_Bulletin.txt
government/Media/Legal_services_for_poor.txt
government/Media/Farm_workers.txt
government/Media/Entities_Merge.txt
government/Media/less_legal_aid.txt
government/Media/Understanding.txt
government/Media/Do-it-yourself_divorce.txt
government/Media/Politician_Practices.txt
...more lines...
plos/journal.pbio.0020013.txt
plos/pmed.0020055.txt
plos/pmed.0020082.txt
plos/pmed.0010021.txt
plos/pmed.0010034.txt
plos/pmed.0010008.txt
plos/pmed.0020120.txt
plos/journal.pbio.0020172.txt
plos/pmed.0020040.txt
plos/pmed.0020068.txt
plos/journal.pbio.0020012.txt
plos/pmed.0020281.txt
plos/pmed.0020242.txt
... 
```

That's a lot of lines! In fact it's so many that it seems to have reached the limit of visual studio code, since I can't see the command that I called before this happened! It seems like writing ```find *``` in the technical directory made the computer search for all files within the technical directory, as well as the files within each subdirectory! Something that you'd also notice is that the computer searched through sub-subdirectories as well, an example being in the government folder where a search result returned ```government/Media/less_legal_aid.txt```. Overall, this is useful because we can manipulate all this data to do many things, for example we can check what the extensions are, or look at the path names and see if there's a pattern. 


#### Example 2 Find in plos directory:
That was way too many lines. We can tone it down a little by changing our directory from technical to something more specific. Let's try changing our directory to /plos by doing ```cd plos``` and try the ```find *``` command again:
```
journal.pbio.0030102.txt
journal.pbio.0030105.txt
journal.pbio.0030127.txt
journal.pbio.0030129.txt
journal.pbio.0030131.txt
journal.pbio.0030136.txt
journal.pbio.0030137.txt
...more lines...
pmed.0020246.txt
pmed.0020247.txt
pmed.0020249.txt
pmed.0020257.txt
pmed.0020258.txt
pmed.0020268.txt
pmed.0020272.txt
pmed.0020273.txt
pmed.0020274.txt
pmed.0020275.txt
pmed.0020278.txt
pmed.0020281.txt
```

That's still a lot of files, but thankfully this time it didn't go past the limit for the terminal on visual studio code! It seems like the find* command has been funneled into the /plos directory so that the valid files to be searched are only in this directory. There are no directories in this folder, but it doesn't matter since this particular version of ```find``` doesn't care about directories. Overall, a useful thing we can do with this is to see what types of files are in a specific directory, for example we noticed already that there are a lot of .txt files in this plos directory. And we can manipulate the output if we wanted.


#### Example 3: Find in Env_Prot_Agen directory
That was interesting! We can narrow this down even more by going into a directory that contains few files. In this way our terminal won't be cluttered by the files and we can look at them one by one. Let's go to the Envr_Prot_Agen folder by going back to technical with ```cd ..``` and doing ```cd government/Env_Prot_Agen```. Finally, let's do ```find *``` and see what happens. 
```
1-3_meth_901.txt
atx1-6.txt
bill.txt
ctf1-6.txt
ctf7-10.txt
ctm4-10.txt
final.txt
jeffordslieberm.txt
multi102902.txt
nov1.txt
ro_clear_skies_book.txt
section-by-section_summary.txt
tech_adden.txt
tech_sectiong.txt
```

Finally we get a manageable chunk! This chunk of files is definitely easier to read than the last chunk of files. In fact, we can do some operations with these files if we are even more curious. So now we know for sure how the asterisk works in tandem with the find command, at least. It basically goes through all the files in the folder and lists the files as relative paths, which explains the behavior that happened when I did ```find *``` from the technical directory (which had some sub-sub-directories!). This is very useful if we wanted to pipe this output into another place to do some other action with this.


### ```find . -type d```
After a bit of online searching, I found this unique set of commands. The ```.``` stands for "current working directory," the ```-type``` portion stands for the type of the file the ```find``` command wants, and the ```d``` stands for "directory" (this is what the find command will search for). Basically, we can use this command to search for directories instead of files!

#### Example 1: Government directory
Let's try to use this command in the government directory. Starting from technical, we can change the directory to government by doing ```cd government.``` Then, we can do ```find . -type d```. Here's our result:

```
.
./About_LSC
./Env_Prot_Agen
./Alcohol_Problems
./Gen_Account_Office
./Post_Rate_Comm
./Media
```
It looks like this command did its job! Something interesting is that there's a dot in the beginning of the output. This wouldn't be the case if we did this command but replaced the dot with an asterisk. Perhaps the dot is just counting the current working directory as a directory? Either way, the function did what it was supposed to do, which is find all the directories within this directory. This is useful because we can have a good overview of the amount of directories in a single directory and can possibly keep this in mind or save this text to show to other people.

#### Example 2: About_LSC Directory
What happens if we run this command in a directory that doesn't have other directories? Let's try this by changing directory to About_LSC with ```cd government/About_LSC``` and running the command:
```

```

Nothing happened! This was expected because there are no directories for ```
find``` to search for. This is useful if we want to quickly know the subdirectories in a directory but we don't want to go into the system explorer and open a new window to see the directory.

#### Example 3: Entire technical directory
Let's repeat the process, but with the entire technical directory.

```
.
./government
./government/About_LSC
./government/Env_Prot_Agen
./government/Alcohol_Problems
./government/Gen_Account_Office
./government/Post_Rate_Comm
./government/Media
./plos
./biomed
./911report
```

It looks like this command found every directory within the technical directory, as well as the sub-subdirectories! Neat! Something that's different to the last command we did was that switching the ```*``` with ```.``` . Basically if we did the last command with the asterisk, we would've gotten the same output, except without the dot and slash before each path. The dot could arguably be more descriptive since it stands for "current working directory" (so we could replace the dot with the full path before the path after the dot). Still, the asterisk would work well if we wanted these directories as relative paths instead of absolute paths. Overall, this command helps a lot if we want to find directories with the command line, and even moreso if we want to do an action with this text that we just got by copypasting/piping the output to another command.

### ```find * -size -2k ```
This command may look like the find command from last time, but this one has an asterisk instead of a dot. Also, it checks the size of files instead of the directories! -2k stands for 2 kilobytes. I could've made the find command check for files bigger or smaller than the posted size, and for me I chose files smaller than 2 kb. Let's try it out.

#### Example 1: Searching through the plos directory
Let's try searching through the plos directory. Through doing this, we get the output:
```
pmed.0020028.txt
pmed.0020048.txt
pmed.0020082.txt
pmed.0020120.txt
pmed.0020157.txt
pmed.0020191.txt
pmed.0020192.txt
pmed.0020226.txt
```

That's interesting. There are really not many files in the plos directory that are less than 2kb. It may mean that most text files in this entire technical directory are worth more than 2kb. Still, there doesn't seem to be any other files in this directory which may suggest that txt files are very small compared to other types of files. This can help us know the relative sizes of text files.

#### Example 2: Searching through the media directory
Let's try searching through the media directory with ```cd government/media``` after going back to technical.

```
Campaign_Pays.txt
Court_Keeps_Judge_From.txt
Fire_Victims_Sue.txt
Helping_Hands.txt
It_Pays_to_Know.txt
Justice_requests.txt
Lawyer_Web_Survey.txt
Self-Help_Website.txt
Wilmington_lawyer.txt
```

Great, there's a few files here. Again most of these files are text which is understandable since text tends to be less space-intensive than media. This idea is useful because we have more insight into the fact that txt files seem to be the most common files that are quite small. This can help us know the average sizes of txt files.

#### Example 3: Searching through the entire Env_Prot_Agen directory
Let's try searching through the Env_Prot_Agen directory after going from technical by doing ```cd government/Env_Prot_Agen```. We get this output:
```

```

It looks like the Env_Prot_Agen directory has no files under 2 kb. This is useful because we can tell the size of the files in directories without having to look through each one. Let's say if we have many files, we won't have to look through each one. Instead, we can use this command (Perhaps use it with a script) and it will get info for us. We can change the size and the parameters to search for the sizes of specific files.