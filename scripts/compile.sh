#!/bin/bash
cd ..
rm -rf bin
mkdir -p bin
cd src
./../../javacc-6.0/bin/jjtree -OUTPUT_DIRECTORY="parser" parser/Jmm.jjt
./../../javacc-6.0/bin/javacc -OUTPUT_DIRECTORY="parser" parser/Jmm.jj
cd ..
javac -d bin -sourcepath . src/*/*.java
