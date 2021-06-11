@ECHO off
mkdir bin
javac -d bin numtri.java
copy numtri.in bin\numtri.in > nul
copy numtri.out bin\numtri.out > nul
cd bin
java numtri
cd..
move bin\numtri.out numtri.out > nul
rmdir /q /s bin
