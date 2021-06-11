@ECHO off
mkdir bin
javac -d bin ariprog.java
copy ariprog.in bin\ariprog.in > nul
copy ariprog.out bin\ariprog.out > nul
cd bin
java ariprog
cd..
move bin\ariprog.out ariprog.out > nul
rmdir /q /s bin
