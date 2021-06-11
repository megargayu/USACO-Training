@ECHO off
mkdir bin
javac -d bin frac1.java
copy frac1.in bin\frac1.in > nul
copy frac1.out bin\frac1.out > nul
cd bin
java frac1
cd..
move bin\frac1.out frac1.out > nul
rmdir /q /s bin
