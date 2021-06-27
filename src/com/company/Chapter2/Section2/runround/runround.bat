@ECHO off
mkdir bin
javac -d bin runround.java
copy runround.in bin\runround.in > nul
copy runround.out bin\runround.out > nul
cd bin
java runround
cd..
move bin\runround.out runround.out > nul
rmdir /q /s bin
