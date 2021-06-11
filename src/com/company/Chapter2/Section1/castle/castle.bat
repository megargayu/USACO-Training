@ECHO off
mkdir bin
javac -d bin castle.java
copy castle.in bin\castle.in > nul
copy castle.out bin\castle.out > nul
cd bin
java castle
cd..
move bin\castle.out castle.out > nul
rmdir /q /s bin
