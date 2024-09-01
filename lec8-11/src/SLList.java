package src;
import edu.princeton.cs.algs4.In;
import net.sf.saxon.expr.ItemMapper;
import org.apache.bcel.generic.PUSH;

import java.util.ArrayList;

public class SLList<Item> implements GenericList<Item> {

    private class ItemNode {
        public Item item;
        public ItemNode next;

        // insert the node always after the node p if we use p = new ItemNode(p,value);
        ItemNode(Item i, ItemNode n) {
            item = i;
            next = n;
        }
    }

    /* The first node , if it exists. It's behind the sentinel. */
    private ItemNode sentinel;
    private int size;

    public SLList(Item x) {

        sentinel = new ItemNode(null,null);
        addFirst(x);
        size++;
    }

    public SLList() {
        sentinel = new ItemNode(null, null);
        size = 0;
    }

    @Override
    public void addFirst(Item x) {
        sentinel.next = new ItemNode(x, sentinel.next);
        size++;
    }

    @Override
    public Item getFirst() {
        return sentinel.item;
    }

    @Override
    public void addLast(Item x) {
        ItemNode p = sentinel;
        while (p.next != null) p = p.next;
        p.next = new ItemNode(x, null);
        size++;
    }

    @Override
    public Item removeLast() {
        ItemNode back = getLastNode();
        if (back == sentinel) return null;

        size--;
        ItemNode p = sentinel;
        while (p.next != back) p = p.next;
        p.next = null;    //set the lastNode of SLList to null
        return back.item;

        /* use the back directly maybe better? */
//        else
//        {
//           Item value =back.item;
//           size--;
//           back=null;
//           return value;
//        }

        // no because getLastNode may return sentinel

    }


    // we allow the last node can be sentinel!
    public ItemNode getLastNode() {
        ItemNode p = sentinel;
        while (p.next != null) p = p.next;
        return p;
    }

    @Override
    public Item getLast() {
        ItemNode p = sentinel;
        while (p.next != null) p = p.next;
        return p.item;
    }

    @Override
    public Item get(int i) {
        int tmpSize = 0;
        ItemNode p = sentinel;
        while (tmpSize != i) {
            p = p.next;
            tmpSize++;
        }
        return p.item;
    }

    @Override
    public void print() {

        System.out.println("Overridden print method in SLList");
        ItemNode p = sentinel.next;
        while (p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();

    }

    @Override
    // We want a  faster way to get the size by cache the size while we do insert or remove
    public int size() {
        return size;
    }

    @Override
    public void clear()
    {
        size=0;
        sentinel.next=null;
    }

    // return an  ordered ArrayList of all members of List
    public ArrayList<Item> toList()
    {
        ArrayList<Item> res = new ArrayList<>();

        ItemNode back =getLastNode();
        if(back==sentinel) return res;

        ItemNode p =sentinel;

        // we step into the list and cover every node for its item and the push to the next node.
        while (p!=back)
        {
            p=p.next;
            res.add(p.item);
        }
        return res;
    }

//    /* Since there is no recursion in SLList. We need to create it! */
//    public Item size() {
//        return size(sentinel);
//    }
//
//    private Item size(ItemNode p) {
//        if (p.next == null)
//            return 1;
//        else
//            return 1 + size(p.next);
//    }


}
