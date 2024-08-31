import edu.princeton.cs.algs4.In;

public  class  Test
{
    public static void main(String[]args)
    {
        /* if dynamic-type override the method. use the  method  that was overridden */
        System.out.println();
        GenericList<Integer> gel = new AList<Integer>();
        for(int i=0;i<4;i++)
            gel.addFirst(i);
        for(int i=-1;i>-4;i--)
            gel.addLast(i);
        gel.print();

        GenericList<Integer> gelSll = new SLList<Integer>();
     for(int i=0;i<4;i++)
            gelSll.addFirst(2*i);
        for(int i=-1;i>-4;i--)
            gelSll.addLast(2*i);

        gelSll.print();

        System.out.println("interface inheritecne!");
    }
}