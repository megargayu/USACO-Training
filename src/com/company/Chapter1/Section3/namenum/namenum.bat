@ECHO off
mkdir bin
javac -d bin namenum.java
copy namenum.in bin\namenum.in > nul
copy namenum.out bin\namenum.out > nul
copy dict.txt bin\dict.txt > nul
cd bin
java namenum
cd..
move bin\namenum.out namenum.out > nul
rmdir /q /s bin
