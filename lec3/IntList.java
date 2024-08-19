public class IntList {
    int first;
    IntList rest;

    IntList(int x) {
        first = x;
        rest = null;
    }


    IntList(int x, IntList r) {
        first = x;
        rest = r;
    }

    /* return the  size of IntList using recursion. */
    public int size() {
        if (this.rest == null) {
            return 1;
        } else {
            return 1 + rest.size();
        }
    }

    public int iterativeSize() {
        IntList p = this;
        int size = 0;
        while (p != null) {
            size++;
            p = p.rest;
        }

        return size;
    }

    public static void main(String[] args) {

        /* Created first IntList. Add elements backward! */
        IntList il = new IntList(5, null);
        il.rest = new IntList(10, null);
        il.rest.rest = new IntList(15, null);

        /* Created second IntList. Add elements forward*/
        IntList secondil = new IntList(3, null);
        secondil = new IntList(6, secondil);
        secondil = new IntList(9, secondil);
        secondil = new IntList(12, secondil);

        System.out.println(secondil.size());
        System.out.println(secondil.iterativeSize());
    }
}
