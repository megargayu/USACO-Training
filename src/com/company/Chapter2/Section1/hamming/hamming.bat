@ECHO off
mkdir bin
javac -d bin hamming.java
copy hamming.in bin\hamming.in > nul
copy hamming.out bin\hamming.out > nul
cd bin
java hamming
cd..
move bin\hamming.out hamming.out > nul
rmdir /q /s bin
