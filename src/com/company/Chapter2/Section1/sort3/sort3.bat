@ECHO off
mkdir bin
javac -d bin sort3.java
copy sort3.in bin\sort3.in > nul
copy sort3.out bin\sort3.out > nul
cd bin
java sort3
cd..
move bin\sort3.out sort3.out > nul
rmdir /q /s bin
