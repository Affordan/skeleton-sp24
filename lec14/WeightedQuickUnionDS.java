import java.lang.Math;

import static java.lang.Math.abs;

public class WeightedQuickUnionDS implements DisjointSets {
    private int[] items;
    private int size;

    WeightedQuickUnionDS() {
        size = 10;
        items = new int[size];
        for (int i = 0; i < size; i++) items[i] = -1;
    }

    // find the root node of one node if it has a root
    //default root is -1
    private int root(int node) {
        int root = node;
        //travers up tree find root node
        while (items[root] >=0) {
            root = items[root];
        }
        return root;
    }

    private int size(int node) {
        return abs(items[node]);
    }

//    private void mount(int root, int node) {
//        items[node] = root;
//    }

//    //convert the root of 2 trees order doesn't matter
//    private void merge(int parentTreeRoot, int subTreeRoot) {
//        if(abs(items[parentTreeRoot])>abs(items[subTreeRoot]))
//        {
//            items[parentTreeRoot]+=items[subTreeRoot];
//
//        }
//    }

    // order of arguments shouldn't affect the implement logic
    private void merge(int sup, int sub) {
        int root = root(sup);
        items[root] += items[sub];   //update the sup root value
        items[sub] = sup;//set root of sub to be sup
    }

    @Override
    // we default head to be the root if x equals y
    public void connect(int x, int y) {
        if (size(root(x))>=size(root(y))) {
            merge(x,y);
        } else {
            merge(y, x);
        }


    }

    @Override
    public Boolean isConnected(int x, int y) {
        return root(x) == root(y);
    }

    public void print()
    {
        StringBuilder str= new StringBuilder();
        str.append("[");
        for(int i=0;i<size;i++)
        {
            str.append(items[i]);
            if(i!=size-1)
                str.append(",");
        }
        str.append("]");

        System.out.println(str.toString());
    }
    public static void main(String[] args) {
        WeightedQuickUnionDS wds = new WeightedQuickUnionDS();
        wds.connect(0,1);
        wds.connect(1,7);
        wds.connect(0,4);



        wds.connect(5,6);
        wds.connect(5,8);
        wds.print();
        System.out.println(wds.isConnected(0,6).toString());

        wds.connect(4,5);
         wds.print();
        System.out.println(wds.isConnected(0,6));

    }


}
