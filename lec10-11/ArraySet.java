import java.util.Iterator;

public class ArraySet<T> implements Iterable<T> {

    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public void add(T x) {
        if (contains(x)) return;
        if (size < items.length) {
            items[size] = x;
            size++;
        }
    }


    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(x)) return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void print() {
//        for(int i=0;i<size;i++ )
//            System.out.println(items[i]);

//        iterate all item in items contains null not good
        for (var i : items)
            System.out.println(i);
    }

    public class ArraySetIterator implements Iterator<T> {
        int wizPos;
        T item;

        public ArraySetIterator() {
            wizPos = 0;

        }

        @Override
        public boolean hasNext() {
            if (wizPos < size) return true;
            return false;
        }

        @Override
        public T next() {
            T returnItem = items[wizPos];
            wizPos++;

            return returnItem;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for(var i :this)
            str.append(i+", ");

        str.append("]");

        return str.toString();
    }

    @Override
    public boolean equals(Object obj) {

        /* check whether obj is an instance of ArraySet  return true if it is else return false
        *  true : cast obj to ArraySet
        * */
       if(obj instanceof ArraySet arrset)
       {
           if(this.size!=arrset.size)return false;
           for(T a:this)
           {
               if(!arrset.contains(a))
                   return false;
           }
           return true;
       }
       return false;
    }

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(34);
        aset.add(78);
        aset.add(98);
        aset.add(23);

        for (var i : aset)
            System.out.println(i);
        System.out.println(aset.toString());

         ArraySet<Integer> aset2 = new ArraySet<>();
        aset2.add(34);
        aset2.add(78);
        aset2.add(98);
        aset2.add(23);

        System.out.println(aset==aset2);
        System.out.println(aset.equals(aset2));
        //aset.print();
    }


}
