@ECHO off
mkdir bin
javac -d bin dualpal.java
copy dualpal.in bin\dualpal.in > nul
copy dualpal.out bin\dualpal.out > nul
cd bin
java dualpal
cd..
move bin\dualpal.out dualpal.out > nul
rmdir /q /s bin
