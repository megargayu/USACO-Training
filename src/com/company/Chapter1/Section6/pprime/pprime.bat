@ECHO off
mkdir bin
javac -d bin pprime.java
copy pprime.in bin\pprime.in > nul
copy pprime.out bin\pprime.out > nul
cd bin
java pprime
cd..
move bin\pprime.out pprime.out > nul
rmdir /q /s bin
