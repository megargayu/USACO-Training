@ECHO off
mkdir bin
javac -d bin milk2.java
copy milk2.in bin\milk2.in > nul
copy milk2.out bin\milk2.out > nul
cd bin
java milk2
cd..
move bin\milk2.out milk2.out > nul
rmdir /q /s bin
