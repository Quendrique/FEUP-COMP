# COMP 18/19: Java-- Parser

## How to run

### Unix

> Compilation

```
./compile.sh
```

> Executing the program targeting all test files

```
./run-all.sh
```

> Executing the program targeting a specific folder or file (the 'fileName' argument is optional)

```
./run-single.sh <directory> <fileName>
```

## Summary

This project was developed for the Compilers course unit taught at FEUP; it aims to implement a Java-- (a subset of the Java language) compiler, capable of performing syntatic and semantic analysis as well as code generation.

## Syntatic analysis

During syntatic analysis, the execution of the program is stopped immediately should an error be encountered, with the exception of while conditions. If an error is discovered in that context, a message containing all the necessary information to locate the error is displayed and the analysis carries on; this process repeats itself up to 10 times. If the limit is reached, then the execution is aborted.  

## Semantic analysis

The semantic analysis performed by the compiler at hands seeks to highlight a wide number of possible errors, some of which are mentioned below and most of which are showcased in the test files included in the project:

- Two variables (within the same scope) cannot have the same identifier;
- During assignments, the left-hand side and the right-hand side of the statement must be of the same type;
- A call to a method of a non-static class must be performed on an instanced variable of that class (var.call() - var must be initialized);
- A function's return value must match the type of that function's signature;
- A variable must be declared before its use;
- The 'not' operation can only be performed on boolean values;
- Both sides of an arithmetic as well as of a 'less than' operation must be of type int;
- Both sides of an 'and' operation must be of type boolean;
- The length property is only applicable to arrays;
- The expression within an 'if' condition must return a boolean value;
- The expression within a 'while' condition must return a boolean value;
- An array index must be of type int;
- An array position can only be accessed in an array (i[2] - the variable 'i' must be an array);
- Methods cannot be called on primitives;
- A function call to a method of that class must have a corresponding function definition (function calls from external classes and static calls will be addressed shortly).

During the conception and analysis of the possible error scenarios, a number of conceptual obstacles were found, namely the possibility of function overloading, the call to functions external to the class and, in a similar fashion, the call to static functions. Each of these problems will be briefly discussed in the subsequent sections.

### Function overloading

The original strategy adopted to implement symbol tables - a primary mapping of function identifiers to their respective symbol tables, accompanied by an auxiliary mapping in charge of global variables - did not allow for the existence of multiple functions with the same identifier and differing parameters. However, a minor change to the way functions are identified solved this particular problem: as opposed to being solely characterized by their identifiers, the mapping of functions to symbol tables is now done with the key being product of the concatenation of a function's identifier and the types of its parameters.

### Polymorphism

Although polymorphism did not impose a substantial number of challenges in regards to semantic analysis, some measures were taken in order to account for the limitations of this compiler. As such, whenever a class extends another, function calls to objects of the class in question which do not have a corresponding definition are nonetheless assumed to be valid, as said definitions can be (albeit not necessarily) present in the ascending class.

### Static calls

Static calls proved to be one of the most challenging aspects of this project, considering the amount of assumptions and checks that need to be performed in order to avoid false-positives in the error detection phase. On the one hand, the existence of the class used in a static call is assumed, as well as the function itself. On the other hand, the return type of the static method shifts in accordance to the context in which it is used. Consider the following example:

```
int a;
boolean b;

a = MathUtils.random(0, 10);
b = MathUtils.random(0, 10, true);
```
Since there is no way of knowing the return type of the function random(), the compiler must assume that it returns exactly what it need for the assignment to be correct. In practice, this may not be the case (random may not be overloaded to return the values necessary values in the example above, ...); however, this was considered to be the preferable approach, as the placement of some amount of trust in the user to not perform invalid static calls extends the versatility of compiled programs by a considerable amount.

### External function calls

Finally, external calls follow a similar approach to that of static function calls, with the exception that they must be performed on an initialized instance variable of the class in question: all function calls are considered to be valid and their return types equally so.

## Code generation

A segmented approach to code generation was adopted, as it results in more comprehensible code as well as in a more painless debugging process. As such, the AST is recursively traversed, each node generating the corresponding (if any) jasmin code, appending it to .j file. Lower cost instructions were used in the loading process of variables with a lower index number (iload_1, iload_2, iload_3) as well as in the loading of constant values (iconst for values between 0 and 5, bipush for values up to 127, ...). In addition, the instructions for comparisons between a value and 0 (ifge, ifgt, ifle, ...) were used whenever possible (in 'if' conditions, for example). The application of while templates is discussed thusly

### While templates

In order to determine if the benefits of use of while templates outweight the costs, a simple analysis function was implemented. Should the 'while' condition be considered simple (either constituted by a single variable or constant or a logic operation in which both the right and left-hand sides are simple variables or constants), then the following structure is adopted;

```
; while(true)
iconst_1
ifeq WHILE_NEXT_0
WHILE_0:
;(...)
iconst_1
ifne WHILE_0
WHILE_NEXT_0:
```

While the 'while' expression is evaluated twice, the use of costly 'goto' instructions is avoided. On the other hand, if the analysis fails, the template for the loop is slightly altered:

```
; while(i < field.length)
WHILE_2:
iload_1
aload_0
getfield Life/field [I
arraylength
isub
ifge LT_ELSE_2
iconst_1
goto LT_NEXT_2
LT_ELSE_2:
iconst_0
LT_NEXT_2:
ifeq WHILE_NEXT_2
;(...)
goto WHILE_2
WHILE_NEXT_2:
```


### Stack controller

The evaluation of a function's maximum stack height starts with the attribution of costs to each possible instructions: for example, an iload instruction has a cost of 1, as it increases the stack height by that amount, where an iadd instructions has a cost of -1, given that it removes two values from the stack and places the result of the computation of top of it. During code generation, costs are added and subtracted accordingly, guaranteeing that, by the end of a function's evaluation,the maximum value registered during the course of these calculations is the minimum number of stack positions that must be reserved.

### -o optimization

In regards to optimizations, the use of constant propagation was implemented, taking solely into consideration assignments where the right-hand side of the operation was a simple operand; cases such as 'y = 2 * 3 + 4' were not considered. Thusly, the following Java-- code

```
int x;
int y;
x = 5;
y = x + 6;
```

is translated to

```
iconst_5
istore_1
iconst_5
bipush 6
iadd
istore_2
```

assuming the code is part of a non-static function with no arguments. Should a variable be used in a while loop or an if statement, then its value is not propagated.

## Tests

A set of test files was included in order to efficiently demonstrate the compiler's error detection capabilities during syntatic and semantic analysis as well as the code generation. All of the files are present in the 'tests' folder, subsequently subdivided into the aforementioned sections. 

## Overview

This project is divided in three packages: 

- parser - responsible for the syntatic and semantic analysis;
- semantic - responsible for classes dealing with the representation of the symbol table;
- codeGeneration - responsible for the generation of .j files.

The -o optimization (related to constant propagation) was implemented; the use of while templates is done by default;

### Pros

As mentioned in previous sections, some additional features were added:

- Function overloading;
- Constant propagation;
- Lower cost comparison instructions (ifeq, ifgt, ifge, ...); 
- Lower cost variable loading instructions (iload_1, istore_1, ...).

### Cons

More optimization measures could be have been implemented, such as register allocation, loop unfolding, constant folding, ...

## Contributions

- António Cruz (up201603525): 25% 
- Beatriz Mendes (up201604253): 25%
- Dinis Moreira (up201503092): 25%
- Mariana Costa (up201604414): 25%
