@ECHO off
mkdir bin
javac -d bin beads.java
copy beads.in bin\beads.in > nul
copy beads.out bin\beads.out > nul
cd bin
java beads
cd..
move bin\beads.out beads.out > nul
rmdir /q /s bin
