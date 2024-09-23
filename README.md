# lab

lab01: completed Arithmetic.java 14/8/2024


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

## lec8 interface and implements

### harvest

<b>interface is an abstraction of behavior</b>

inheritance contains <i> interface</i> and <i> partial implementation</i> the latter includes some <b>default code </b>.

<br>

<b>Any type in java has 2 type <i>dynamic type</i>(runtime type) and <i>static type</i>(declaration ype) </b>

here are the definition of 3 class
<code>public interface GenericList\<Item>
public class Alist\<Item> implements GenericList\<Item>
public class SLList\<Item> implements GenericList\<Item></code>

Suppose we have code follows

```java
GenericList<Integer> gelAList = new AList<Integer>();
GenericList<Integer> gelSLList = new SLList<Integer>();
```

| Reference | dynamic type | static type |
| --------- | ------------ | ----------- |
| gelAList  | Alist        | GenericList |
| gelSLList | SLList       | GenericList |

## lec9 extends and supper

### note

- is-a and has-a
- encapsulation
- <b> complier is only checking based on static type</b>

This lecture we build VengefulSLList and RotatingSLList.Both of them are the subclass of SLList.

```java
public class VengefulSLList<Item> extends SLList<Item>
public class RotatingSLList<Item> extends SLList<Item>
```

is-a relationship refer to subclass before keyword of extends is a subset of superclass after keyword of extends.

$$
\begin{array}{c}
\boxed{
    \begin{array}{c}
    \text{SLList} \\
    \\
    \boxed{\text{VengefulSLList}} \quad \boxed{\text{RotatingSLList}}
    \end{array}
}
\end{array}
$$

<br>

**From top to bottom ,top has bottom ,bottom is a top.**
![](./imgs/inheritance.png)

<br>
<b> You can use super in subclass to visit private method of super class</b>
here is a piece of code in  <code>RotatingSLList </code>

```java
  public void rotate()
    {
      super.addFirst(super.removeLast());
    }
```

## lec12 Asymptotic

### note

I really admire this ppt which explains $O(n),\Theta(n),\Omega(n)$ very clearly.
![](./imgs/OrderOfGrowth.png)

We have following definition.

For given constant positive $c_0$ and $n$ we have function $f(n)$

- O(n) $O(g(n))\quad satisfy \quad c_0\times g(n)\geq f(n)$ means greter than or equal
- $\Omega(n)$ $\Omega(g(n))\quad satisfy \quad c_0\times g(n)\leq f(n)$means less than or equal
- $\Theta(n)$ $\Theta(g(n))\quad satisfy \quad k_1\times g(n)\leq f(n)\leq k_2\times g(n) $ means euqal

  | $f(n)$            | $O(n)$             | $\Omega(n)$               | $\Theta(n)$ | $o(n)$     |
  | ----------------- | ------------------ | ------------------------- | ----------- | ---------- |
  | $3n^2+4\sin(n)+5$ | $O(n^2),O(n^3)...$ | $O(n^2),O(nlogn),O(n)...$ | O(n^2)      | O(n^3),... |

## harvest

Actually we use asymptotic to measure our program mathematically not by run it practically the worst idea to test its whatever things!

## lec13 Disjoint Sets

Let's see a definition of sets
![](./imgs/sets.png)
disjoint sets is a series sets that can check whether 2 elements is connected or connect 2 elements (their sets will be connected too.)

```java
public interface DisjointSets<T>
{
    void connect(T x ,T y);
    boolean isConnected(T x,T y);
}
```

\
we'll introduce 3 method to complete the data structure.ListOfSetsDS seems our head of this idea so we just mention it.
The idea that using an array to store the sets and make elements of a set to be the same value in the array. **great idea to check whether 2 elements belongs to one set**

QuickUnionDS emmmm ,maybe something like tree
|value|-1|0|6|0|3|3|-1|6|-1|
|------|------|------|------|------|------|------|------|------|------|
|index|0|1|2|3|4|5|6|7|8|


In the tree or this array,one item is either a single node(value = -1) or a 
tree node( root node or common node doesn't matter).If this node is a single node we call `mount` to hanging the node under the tree,if tree node
we call  `merge` to merge 2 trees according to its weight.The question is how do we merge 2 trees?Call `root` find the root node of the tree then merge it become so easy. **don't forget update the root value(size of the tree)** 

\
It seemns that `mount` method  is dull so we give it up.



![](<./imgs/[61B%20SP24]%20Lecture%2014%20-%20Data%20Structures%201_%20Disjoint%20Sets%20(1).png>)




# project

## pro0

The idea of moving one single tile and then a column then the whole board is great. And the most powerful idea is using `setViewingPerspective` method to control.Show my game.
![](./imgs/game2048.gif)

## pro1A LinkedListDeque

>A common beginner mistake is to write a large amount of code and hope that it all works once you’re finished. 

