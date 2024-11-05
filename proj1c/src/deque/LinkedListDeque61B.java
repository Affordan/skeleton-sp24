package deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T>,Iterable<T> {



    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */

    private class LNode {
        public LNode prev;
        public T item;
        public LNode next;

        LNode(T i, LNode n) {

            item = i;
            next = n;
//            n.prev=this;
        }

//        LNode(LNode p,T i)
//        {
//            prev=p;
//            p.next=this;
//            item=i;
//        }

        /** ...
         * @param  p p is the previos node of this node
         * @param i i is the item of this node
         * @param n n is the next node of this  node
        * */
        /* this node is behind p and before n */
         LNode(LNode p, T i, LNode n) {
            prev = p;
            p.next = this;
            item = i;
            next = n;
            n.prev = this;

        }

    }


    private LNode sentFront;
    private LNode sentBack;
    private  int size_;

     public void initSentinel() {
        sentFront = new LNode(null, null);
        sentBack = new LNode(null, null);
        sentFront.next = sentBack;
        sentBack.prev = sentFront;
    }
    LinkedListDeque61B() {
        size_=0;
        initSentinel();
    }

    @Override
    public void addFirst(T x) {
        new LNode(sentFront,x,sentFront.next);
    }

    @Override
    public void addLast(T x) {
        new LNode(sentBack.prev,x,sentBack);
    }

    @Override
    public List<T> toList() {

         List<T> ls=new ArrayList<>();
         LNode p =sentFront.next;
         while(p!=sentBack)
         {
             ls.add(p.item);
             p=p.next;

         }
        return ls;
    }

    @Override
    public boolean isEmpty() {
        return size_==0;
    }

    @Override
    public int size() {
        return size_;
    }

    @Override
    public T removeFirst() {
         LNode p=sentFront.next;
         sentFront.next=p.next;
         p.prev=sentFront;
        return p.item;
    }

    @Override
    public T removeLast() {
        LNode p=sentBack.prev;
        sentBack.prev=p.prev;
        p.next=sentBack;
        return p.item;
    }

    /**...
     * @param index default start by 1
    * */
    @Override
    public T get(int index) {
        if(index>size_||index <=0)
        {
            throw new IndexOutOfBoundsException("Please give a valid index of this deque");

        }
        T res=null;
       int cnt=0;
       if(2*index<size_)
       {

           LNode p=sentFront;
           while(cnt!=index)
           {
               p=p.next;
               cnt++;
           }
           res=p.item;
       }
       else
       {
           LNode p=sentBack;
           while (cnt!=index)
           {
               p=p.prev;
               cnt++;
           }
           res=p.item;
       }

       return res;
    }

    /*》》》》》》》》》》》》》》》》》 How to understand the Iterator() and a class of
    * Iterator that implements the hasNext() and next()
    *
    * from the course we can deduce the left code is equal to right code ( see lec11 9:59 )
    * And that means we should have the iterator() method to return an Iterator Object
    * that Iterator object is only associated with this class (you can define it whatever you want
    *  but we recommend use a class in Parent class and implements the Iterator, we just return a new Object of
    * this specific iterator and implements the hasNext() and next() in the class.
    *
    * The equivalence will automatically call the iterator method and do what like the right code.
    *
    * but first you need to extends the iterable to let java know you are iterable whether it won't
    * change the for each loop automatically to the iterator!
    * */
    private  class SpecificIterator implements Iterator<T>
    {
        private  LNode wizPos ;
        SpecificIterator()
        {
            wizPos=sentFront.next;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return wizPos!=sentBack;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            T returnItem =wizPos.item;
            wizPos=wizPos.next;
            return returnItem;
        }
    }
 /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new SpecificIterator();
    }

    @Override
    public  String toString()
    {

    }

    @Override
    public  boolean equals(Object obj)
    {

    }

    @Override
    public T getRecursive(int index) {

        return null;
    }
}

