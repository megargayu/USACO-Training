@ECHO off
mkdir bin
javac -d bin milk.java
copy milk.in bin\milk.in > nul
copy milk.out bin\milk.out > nul
cd bin
java milk
cd..
move bin\milk.out milk.out > nul
rmdir /q /s bin
