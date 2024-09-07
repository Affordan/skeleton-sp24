public class QuickFindDS implements DisjointSets{
    private int[]items;
    private int size_;

    QuickFindDS()
    {
        size_=1000;
        items=new int[size_];
        for(int i=0;i<size_;i++)
            items[i]=-1;
    }

    // not completed we don't need it
    @Override
    public void connect(int x, int y) {
        if(x>y)
        {
            items[x]=items[y];
        }
        else items[y]=items[x];
    }

    @Override
    public Boolean isConnected(int x, int y) {
        return items[x]==items[y];
    }

    public void print()
    {
        for(int i=0;i<size_;i++)

            System.out.println(items[i]+" ");
    }

    public static void  main(String[]args)
    {

    }
}
