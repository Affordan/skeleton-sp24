package src;

public class VengefulSLList<Item> extends SLList<Item> {
    // a VengefulSLList is a SLList and remember any removed node forever
    private SLList<Item> lostItems;

    public VengefulSLList() {
        super();
        lostItems = new SLList<>();
    }

    @Override
    public Item removeLast() {
        lostItems.addLast(super.getLast());
        return super.removeLast();
    }


    public SLList<Item> getLostItems() {
        return lostItems;
    }

}
