@ECHO off
mkdir bin
javac -d bin barn1.java
copy barn1.in bin\barn1.in > nul
copy barn1.out bin\barn1.out > nul
cd bin
java barn1
cd..
move bin\barn1.out barn1.out > nul
rmdir /q /s bin
