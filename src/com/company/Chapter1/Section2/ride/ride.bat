@ECHO off
mkdir bin
javac -d bin ride.java
copy ride.in bin\ride.in > nul
copy ride.out bin\ride.out > nul
cd bin
java ride
cd..
move bin\ride.out ride.out > nul
rmdir /q /s bin
