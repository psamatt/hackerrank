### Fibonacci Number Challenge

Write a method that returns bach the nth number of a Fibonacci
sequence

A Finonacci sequence looks like the following:
0 1 1 2 3 5 8 13 21 34 55 ...

There are two ways to implement this, a iterative approach using a 
loop or a recursive approach. Implement both and describe which one is 
preferred and why?

Answer: 

Recursion usese more memory due to language maintaining call stack, 
thus being generally slower. In Java for example, the compiler requires an allocation of a new stack frame. 
If you're using a functional language, recursion might be faster. If you're using an imperative language, iteration is probably faster. In some environments, both methods will result in the same assembly being generated.

Higher order functions such as map, reduce o

Recursion makes the code much smaller and cleaner generally

Recursion has a condition as to when to end, can cause a StackOverflow problem

Some languages such as Tail Call implementations make recursion faster but not always 
supported
