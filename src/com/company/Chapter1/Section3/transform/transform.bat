@ECHO off
mkdir bin
javac -d bin transform.java
copy transform.in bin\transform.in > nul
copy transform.out bin\transform.out > nul
cd bin
java transform
cd..
move bin\transform.out transform.out > nul
rmdir /q /s bin
