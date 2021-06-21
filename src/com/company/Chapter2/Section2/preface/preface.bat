@ECHO off
mkdir bin
javac -d bin preface.java
copy preface.in bin\preface.in > nul
copy preface.out bin\preface.out > nul
cd bin
java preface
cd..
move bin\preface.out preface.out > nul
rmdir /q /s bin
