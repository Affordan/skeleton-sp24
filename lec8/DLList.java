
public class DLList<Item> {


    private class LNode {
        public LNode prev;
        public Item item;
        public LNode next;

        LNode(Item i, LNode n) {

            item = i;
            next = n;
        }

        /* this node is behind p and before n */
        LNode(LNode p, Item i, LNode n) {
            prev = p;
            p.next = this;
            item = i;
            next = n;
            n.prev = this;

        }

//        LNode(LNode p,Item i)
//        {
//            prev = p;
//            item = i;
//        }
    }

    /* The first node , if it exists. It's behind the sentFront. */
    /* The last node  , if it exists. It's before the sentBack. */
    private LNode sentFront;
    private LNode sentBack;
    private int size;

    public void initSentinel() {
        sentFront = new LNode(null, null);
        sentBack = new LNode(null, null);
        sentFront.next = sentBack;
        sentBack.prev = sentFront;
    }

    public DLList(Item x) {
        size = 0;
        initSentinel();
        push_front(x);
        size++;
    }

    public DLList() {
        initSentinel();
        size = 0;
    }

    public void push_front(Item x) {
        new LNode(sentFront, x, sentFront.next);    // what a beautiful line!
        size++;  //  cache the size while we do insert or remove node makes it easier for us to get the size
    }

    public Item front() {
        return sentFront.next.item;
    }

    public void push_back(Item x) {
        new LNode(sentBack.prev, x, sentBack);
        size++;
    }

    public Item back() {
        return sentBack.prev.item;
    }

    public int size() {
        return size;
    }

//    /* Since there is no recursion in SLList. We need to create it! */
//    public Item size() {
//        return size(sentinel);
//    }
//
//    private Item size(ItemNode p) {
//        if (p.next == null)
//            return 1;
//        else
//            return 1 + size(p.next);
//    }

    public static void main(String[] args) {

     /*   SLList sll = new SLList(5);

        sll.addFirst(10);
        sll.addFirst(15);
        sll.addFirst(20);

        System.out.println(sll.size());*/


        DLList<Integer> L = new DLList<>();
        //L.addFirst(5);
        L.push_back(10);
        L.push_front(15);
        L.push_back(5);
        System.out.println("DLList first is " + L.front());
        System.out.println("DLList last is " + L.back());

        System.out.println(L.size());
    }
}

