@ECHO off
mkdir bin
javac -d bin skidesign.java
copy skidesign.in bin\skidesign.in > nul
copy skidesign.out bin\skidesign.out > nul
cd bin
java skidesign
cd..
move bin\skidesign.out skidesign.out > nul
rmdir /q /s bin
