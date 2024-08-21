import edu.princeton.cs.algs4.In;
import org.apache.bcel.generic.PUSH;

public class SLList {


    private class IntNode {
        public int item;
        public IntNode next;

        IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /* The first node , if it exists. It's behind the sentinel. */
    private IntNode sentinel;
    private int size;

    public SLList(int x) {
        size = 0;
        sentinel = new IntNode(x, null);
        size++;
    }

    public SLList() {
        sentinel = new IntNode(0,null);
        size = 0;
    }

    public void addFirst(int x) {
       sentinel.next = new IntNode(x,sentinel.next);
       size++;
    }

    public int getFirst() {
        return sentinel.item;
    }

    public void addLast(int x) {
        IntNode p = sentinel;
        while (p.next != null) p = p.next;
        p.next = new IntNode(x, null);
        size++;
    }

    // We want a  faster way to get the size by cache the size while we do insert or remove
    public int size() {
        return size;
    }

//    /* Since there is no recursion in SLList. We need to create it! */
//    public int size() {
//        return size(sentinel);
//    }
//
//    private int size(IntNode p) {
//        if (p.next == null)
//            return 1;
//        else
//            return 1 + size(p.next);
//    }

    public static void main(String[] args) {

     /*   SLList sll = new SLList(5);

        sll.addFirst(10);
        sll.addFirst(15);
        sll.addFirst(20);

        System.out.println(sll.size());*/


        SLList L = new SLList();
        //L.addFirst(5);
        L.addLast(10);
        System.out.println(L.size());
    }
}
