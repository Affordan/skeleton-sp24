import java.lang.Math.*;

import static java.lang.Math.abs;

public class UnionFind {
    // TODO: Instance variables
    int[] items;
    int size_;

    /* Creates a UnionFind data structure holding N items. Initially, all
       items are in disjoint sets. */
    public UnionFind(int N) {
        // TODO: YOUR CODE HERE
        size_ = N;
        items = new int[size_];
        for (int i = 0; i < N; i++) items[i] = -1;
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        // TODO: YOUR CODE HERE
        return abs(find(v));
    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
        // TODO: YOUR CODE HERE
        if (v >= size_) {
            throw new IllegalArgumentException("Some comment to describe the reason for throwing.");
        }
        return items[v];
    }

    /* Returns true if nodes/vertices V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        // TODO: YOUR CODE HERE
        return find(v1) == find(v2);
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid items are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) {
        // TODO: YOUR CODE HERE
        if (v >= size_) {
            throw new IllegalArgumentException("Some comment to describe the reason for throwing.");
        }
        int res = v;
        while (items[v] >= 0) {
            v = parent(v);
        }
        return v;
    }

    /* Connects two items V1 and V2 together by connecting their respective
       sets. V1 and V2 can be any element, and a union-by-size heuristic is
       used. If the sizes of the sets are equal, tie break by connecting V1's
       root to V2's root. Union-ing an item with itself or items that are
       already connected should not change the structure. */
    public void union(int v1, int v2) {
        // TODO: YOUR CODE HERE
        int root1 = find(v1);
        int root2 = find(v2);


        if (abs(items[root1]) >= abs(items[root2])) //hang root of v2 under root of v1
        {
            items[root1] += items[root2];
            //items[root2] = root1;

            //first hang all iterated node of v2 under root of v1
            while (v2 != root2) {
                int tmp = parent(v2);
                items[v2] = root1;
                v2 = tmp;
            }
            items[v2] = root1;

            while (v1 != root1) {
                int tmp = parent(v1);
                items[v1] = root1;
                v1 = tmp;
            }


            return;
        } else {
            items[root2] += items[root1];
            //items[root1] = root2;
            while (v1 != root1) {
                int tmp = parent(v1);
                items[v1] = root2;
                v1 = tmp;
            }
            items[v1] = root2;

            while (v2 != root2) {
                int tmp = parent(v2);
                items[v2] = root2;
                v2 = tmp;
            }

            return;
        }

    }

    public void print() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < size_; i++) {
            str.append(items[i]);
            if (i != size_ - 1)
                str.append(",");
        }
        str.append("]");

        System.out.println(str.toString());
    }

    public static void main(String[] args) {
        UnionFind wds = new UnionFind(15);
        wds.union(0, 1);
        wds.union(1, 7);
        wds.union(0, 4);


        wds.union(5, 6);
        wds.union(5, 8);
        wds.print();
        //System.out.println(wds.connected(0,6).toString());

        wds.union(4, 6);
        wds.print();
        //System.out.println(wds.connected(0, 6));
        wds.union(10,11);
        wds.union(11,12);
        wds.union(13,14);
        wds.union(14,12);

        wds.print();
        wds.union(14,8);
        wds.print();
    }

}
