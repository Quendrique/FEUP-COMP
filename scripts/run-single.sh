cd ..

rm -rf jasmin
mkdir -p jasmin

cd bin

if [ $# -gt 1 ]; then
   java parser/Jmm ../tests/$1/$2 -o
else
   for f in ../tests/$1/*.jmm; 
       do java parser/Jmm $f -o;
   done
fi

cd ../jasmin

for class in ../tests/external/*.class; 
    do cp $class $PWD;
done



