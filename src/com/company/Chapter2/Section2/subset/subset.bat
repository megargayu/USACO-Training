@ECHO off
mkdir bin
javac -d bin subset.java
copy subset.in bin\subset.in > nul
copy subset.out bin\subset.out > nul
cd bin
java subset
cd..
move bin\subset.out subset.out > nul
rmdir /q /s bin
