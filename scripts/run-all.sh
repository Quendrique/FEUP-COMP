cd ..

rm -rf jasmin
mkdir -p jasmin

cd bin

for f in ../tests/*/*.jmm; 
    do java parser/Jmm $f -o;
done

cd ../jasmin

for class in ../tests/external/*.class; 
    do cp $class $PWD;
done


