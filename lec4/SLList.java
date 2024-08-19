import org.apache.bcel.generic.PUSH;

public class SLList {


    private class IntNode {
     public    int item;
     public    IntNode next;

        IntNode(int i)
        {
            item=i;
            next=null;
        }

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


    public  static  void main(String[] args)
    {

        SLList sll =new SLList(5);
    }
}
