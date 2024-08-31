import edu.princeton.cs.algs4.In;
import net.sf.saxon.expr.ItemMapper;
import org.apache.bcel.generic.PUSH;

public class SLList<Item> implements GenericList<Item> {

    private class ItemNode {
        public Item item;
        public ItemNode next;

        ItemNode(Item i, ItemNode n) {
            item = i;
            next = n;
        }
    }

    /* The first node , if it exists. It's behind the sentinel. */
    private ItemNode sentinel;
    private int size;

    public SLList(Item x) {
        size = 0;
        sentinel = new ItemNode(x, null);
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
    public void removeLast() {
        ItemNode p = sentinel;
        while (p.next != null) p = p.next;
        p = null;
    }

    @Override
    public Item getLast() {
        ItemNode p = sentinel;
        while (p.next != null) p = p.next;
        return p.item;
    }
    @Override
    public  Item get(int i)
    {
        int tmpSize=0;
        ItemNode p =sentinel;
        while (tmpSize!=i)
        {
            p=p.next;
            tmpSize++;
        }
        return p.item;
    }

    @Override
    public void print() {

        System.out.println("Overridden print method in SLList");
        ItemNode p = sentinel.next;
        while (p.next != null) {
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
