# lab

lab01: complted Arithmetic.java 14/8/2024

# lec

## lec4 SLList:

### note

SLList (Static Linked List) provides

```cpp
 addFirst()
 getFirst()
 addLast()
 getLast()
 size()
```

etc.

1. `SLList` contains `IntNode ` class (nested class)
2. We can use recursion of `size(IntNode p)` and `size() ` to compute the size of SLList. But a better choice is declare `private int size` in `SLList`. (Buying additional space for time)
3. Sentinel is important!(Actually I didn't totally understand why we need a sentinel.)

### wisdom

- Less for Users of class to understand (public method -> interface. private method -> implements)
