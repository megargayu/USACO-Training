@ECHO off
mkdir bin
javac -d bin milk3.java
copy milk3.in bin\milk3.in > nul
copy milk3.out bin\milk3.out > nul
cd bin
java milk3
cd..
move bin\milk3.out milk3.out > nul
rmdir /q /s bin
