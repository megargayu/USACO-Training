@ECHO off
mkdir bin
javac -d bin wormhole.java
copy wormhole.in bin\wormhole.in > nul
copy wormhole.out bin\wormhole.out > nul
cd bin
java wormhole
cd..
move bin\wormhole.out wormhole.out > nul
rmdir /q /s bin
