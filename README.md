# USACO Training Problems

Recently, I have decided to start fresh on doing USACO training problems ([train.usaco.org](https://train.usaco.org/)). 
This repository contains my implementation for every USACO training problem I have done, and all of them are 100%
solutions (unless I am still working on them). I have not commented all of them, so it might be hard to understand,
so read the code and try to figure it out for yourself.

### *Please do not copy and paste the answers from this repo. This is only here for educational purposes, and you will not learn if you copy-paste from here.*

## Structure

Every problem is structured like this:
```text
└─── src
     └─── com
          └─── company
              └─── Chapter[chapter number]
                   └─── Section[section number]
                        └─── [problem file name]
```
So, for example, the problem `milk3` in 1.5 would be in src/com/company/Chapter1/Section5/milk3.

Under each problem folder is the following:
- A `.in` file, which takes the input of the program
- A `.out` file, which is where the program outputs
- A `.java` file, which contains all the code used
- A `.bat` file, which is used to run the program, as IntelliJ doesn't allow for relative file reading

## Template

For those who are sick of making new files for each problem, I made a [File Template](https://www.jetbrains.com/help/idea/using-file-and-code-templates.html)
which should be imported by IntelliJ from .idea/workspace.xml. To use it, you have to
1. Create a new directory, where you will store all the files
2. Make this directory a source folder (so there is no `package` statement)
3. Right-click on the directory and click `New > Java Class`
4. Select `USACO Training Problem` from the popup and enter in the file name of the problem (ex. `milk3`)
5. All the files should be generated, including boilerplate input and output code!

All my problems use the following boilerplate code:
```java
/*
ID: megarga1
LANG: JAVA
TASK: TASK_NAME
*/

import java.io.*;

public class TASK_NAME {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("TASK_NAME.in"));
        input.close();
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("TASK_NAME.out")));
        out.close();
    }
}
```
Where `TASK_NAME` is replaced with the actual task name.

Bat files follow this format:
```
@ECHO off
mkdir bin
javac -d bin ${NAME}.java
copy ${NAME}.in bin\\${NAME}.in > nul
copy ${NAME}.out bin\\${NAME}.out > nul
cd bin
java ${NAME}
cd..
move bin\\${NAME}.out ${NAME}.out > nul
rmdir /q /s bin
```
Where `${NAME}` is replaced with the name of the task.

## Running

In order to run any of these programs, run the `.bat` file in the directory. I recommend using the [Batch Scripts 
Support Plugin](https://plugins.jetbrains.com/plugin/265-batch-scripts-support) for IntelliJ which I use in order to run
my programs. 
