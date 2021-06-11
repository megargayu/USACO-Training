@ECHO off
mkdir bin
javac -d bin combo.java
copy combo.in bin\combo.in > nul
copy combo.out bin\combo.out > nul
cd bin
java combo
cd..
move bin\combo.out combo.out > nul
rmdir /q /s bin
