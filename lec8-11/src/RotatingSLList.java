package src;


public class RotatingSLList<Item> extends SLList<Item>{
    public  void rotate()
    {
        super.addFirst(super.removeLast());
    }
}
