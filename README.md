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

Although polymorphism does not impose a substantial number of challenges in regards to semantic analysis, some measures were taken in order to account for the limitations of this compiler. As such, whenever a class extends another, function calls to objects of the class in question which do not have a corresponding definition are nonetheless assumed to be valid, as said definitions can be (albeit not necessarily) present in the ascending class.

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

Finally, external calls follow a similiar approach to that of static function calls, with the exception that they must be performed on an initialized instance variable of the class in question: all function calls are considered to be valid and their return types equally so.

## Code generation

modular approach
recursively traverse the tree generating code on the go
lower cost instructions for the loading of values (iconst_, bipush, ...)
while templates - per iteration at most one jump

### Stack controller

each instruction is associated with a cost in regards to stack usage
at the end of a function the max value determined by that analysis is set as the stacks max value

### -o optimization

constant propagation

## Overview

### Pros

### Cons

register allocation
more optimizations

## Contributions:

- António Cruz (up2016?????): 25% 
- Beatriz Mendes (up2016?????): 25%
- Dinis Moreira (up2015?????): 25%
- Mariana Costa (up201604414): 25%