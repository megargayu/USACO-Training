@ECHO off
mkdir bin
javac -d bin lamps.java
copy lamps.in bin\lamps.in > nul
copy lamps.out bin\lamps.out > nul
cd bin
java lamps
cd..
move bin\lamps.out lamps.out > nul
rmdir /q /s bin
