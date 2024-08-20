import edu.princeton.cs.algs4.In;
import org.apache.bcel.generic.PUSH;

public class SLList {


    private class IntNode {
     public    int item;
     public    IntNode next;

        IntNode(int i,IntNode n)
        {
            item=i;
            next=n;
        }
    }

   private IntNode first;

    public  SLList(int x)
    {
        first =new IntNode(x,null);
    }

    public  void addFirst(int x)
    {
        first = new IntNode(x,first);
    }

    public  int getFirst()
    {
        return  first.item;
    }

    /* Since there is no recursion in SLList. We need to create it! */
    public int size()
    {
        return  size(first);
    }

    private   int size(IntNode p)
    {
        if(p.next==null)
            return 1;
        else
            return 1+size(p.next);
    }

    public  static  void main(String[] args)
    {

        SLList sll =new SLList(5);

        sll.addFirst(10);
        sll.addFirst(15);
        sll.addFirst(20);

        System.out.println(sll.size());
    }
}
