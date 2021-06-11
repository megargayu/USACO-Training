@ECHO off
mkdir bin
javac -d bin gift1.java
copy gift1.in bin\gift1.in > nul
copy gift1.out bin\gift1.out > nul
cd bin
java gift1
cd..
move bin\gift1.out gift1.out > nul
rmdir /q /s bin
