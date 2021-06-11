@ECHO off
mkdir bin
javac -d bin palsquare.java
copy palsquare.in bin\palsquare.in > nul
copy palsquare.out bin\palsquare.out > nul
cd bin
java palsquare
cd..
move bin\palsquare.out palsquare.out > nul
rmdir /q /s bin
