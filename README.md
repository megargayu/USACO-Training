# USACO Training Problems
### megarga1's solutions to USACO training problems

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

For those who are sick of manually making files for each problem (cmon, I can't be the only one who has this problem), 
I made a [File Template](https://www.jetbrains.com/help/idea/using-file-and-code-templates.html) which should be 
imported by IntelliJ from .idea/workspace.xml. To use it, you have to the following:
1. Create a new directory, where you will store all the files
2. Make this directory a source folder (so there is no `package` statement)
3. Right-click on the directory and click `New > Java Class`
4. Select `USACO Training Problem` from the popup and enter in the file name of the problem (ex. `milk3`)
5. All the files should be generated, including boilerplate input and output code!

**You also need to make sure that the Java 8 JDK is on path, meaning you can run `java -version` and `javac -version`
anywhere on your system and it returns something similar to `1.8.0_291`**

However, before you use it, you need to replace the `ID` with your own id. To do this, go to `New > Edit File
Templates`, and scroll all the way down to "USACO Training Problem". Click on "USACO Training Problem" and in the 
sidebar that appears, remove `megarga1` and instead input your own id.

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
Where `TASK_NAME` is replaced with the actual task name. Also, all of my projects use `String.split()` over 
`StringTokenizer` because even though the training pages suggest that you use `StringTokenizer`, the training pages are
old and in Java 8 Java itself recommends using `String.split()` over `StringTokenizer`
[in their docs](https://docs.oracle.com/javase/8/docs/api/java/util/StringTokenizer.html):
> StringTokenizer is a legacy class that is retained for compatibility reasons although its use is discouraged in new 
> code. It is recommended that anyone seeking this functionality use the split method of String or the 
> java.util.regex package instead.


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
