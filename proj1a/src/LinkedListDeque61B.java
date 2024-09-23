import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {

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

    @Override
    public T getRecursive(int index) {

        return null;
    }
}
