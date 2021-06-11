@ECHO off
mkdir bin
javac -d bin test.java
copy test.in bin\test.in > nul
copy test.out bin\test.out > nul
cd bin
java test
cd..
move bin\test.out test.out > nul
rmdir /q /s bin
