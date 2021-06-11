@ECHO off
mkdir bin
javac -d bin friday.java
copy friday.in bin\friday.in > nul
copy friday.out bin\friday.out > nul
cd bin
java friday
cd..
move bin\friday.out friday.out > nul
rmdir /q /s bin
