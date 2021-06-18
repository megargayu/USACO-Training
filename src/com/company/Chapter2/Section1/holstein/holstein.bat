@ECHO off
mkdir bin
javac -d bin holstein.java
copy holstein.in bin\holstein.in > nul
copy holstein.out bin\holstein.out > nul
cd bin
java holstein
cd..
move bin\holstein.out holstein.out > nul
rmdir /q /s bin
