@ECHO off
mkdir bin
javac -d bin crypt1.java
copy crypt1.in bin\crypt1.in > nul
copy crypt1.out bin\crypt1.out > nul
cd bin
java crypt1
cd..
move bin\crypt1.out crypt1.out > nul
rmdir /q /s bin
