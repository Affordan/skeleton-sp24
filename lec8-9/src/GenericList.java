package src;

/* interface allows only method. DON'T TRY TO ADD ANY DATA IN INTERFACE.*/
public interface GenericList<Item> {

    default void print() {
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    public void addFirst(Item x);

    public void addLast(Item x);

    public Item removeLast();

    public Item getFirst();

    public Item getLast();

    public Item get(int i);

    public int size();

    //dangerous !
    //you can still use the list without initialize it but all data stored will be clear
    public void clear();
}

