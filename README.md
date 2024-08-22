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

## lec5:DLList and arrays

### note

Although array is introduced at the end of this lec,I'm already familiar with it.The exact difference of array between C++ and java is that in java array is reference type which means array is actually a pointer.

| feature           | C++          | java         | python           |
| ----------------- | ------------ | ------------ | ---------------- |
| length            | fixed        | fixed        | dynamic          |
| data type         | strong type  | strong type  | wake type        |
| n dimension array | support      | support      | only nested list |
| lib support       | \<algorithm> | Arrays.class | list library     |

Wow! welcome to DLList.I completed it successfully by adding the LNode and made a perfect constructor.

```java
 LNode(LNode p, Cheese i, LNode n) {
            prev = p;
            p.next = this;
            item = i;
            next = n;
            n.prev = this;

        }
```

but be careful about the terrible empty problem solved last lec.

```java
  public void initSentinel() {
        sentFront = new LNode(null, null);
        sentBack = new LNode(null, null);
        sentFront.next = sentBack;
        sentBack.prev = sentFront;
    }
```

I called this in DLList constructor to ensure there must be two faithful sentinel in DLList(one head and one tail).Looks like this.

![](./imgs/2sentinel.png)

And what we should code behind adding the node is one simple line!

```java
  public void push_front(Cheese x) {
        new LNode(sentFront, x, sentFront.next);    // what a beautiful line!
        size++;  //  cache the size while we do insert or remove node makes it easier for us to get the size
    }
```

The amazing process like this **Watch the arrow carefully**
![](./imgs/DLListPush_front.gif)

### harvest

- 2 sentinel
- doubly node (with great constructor)
- `new LNode(sentFront, x, sentFront.next);`
