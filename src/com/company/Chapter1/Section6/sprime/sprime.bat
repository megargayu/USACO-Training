@ECHO off
mkdir bin
javac -d bin sprime.java
copy sprime.in bin\sprime.in > nul
copy sprime.out bin\sprime.out > nul
cd bin
java sprime
cd..
move bin\sprime.out sprime.out > nul
rmdir /q /s bin
