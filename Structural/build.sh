#!/usr/bin/env bash
set -e
mkdir -p out
find src -name "*.java" > sources.txt
javac -d out @sources.txt
if [ "$1" = "demo" ]; then
java -cp out com.modularmedia.Main demo
elif [ "$1" = "test" ]; then
java -cp out com.modularmedia.Main test
else
echo "Usage: $0 [demo|test]"
fi