package src;
/*
 *  Before using this class you're suggested to read this README file
 *  * DEVELOP WHAT YOU NEED WHEN ENCOUNTERING PRO. DO NOT THINK TOO MUCH BEFORE *
 *  * if you want to add some to the last position put it at size.
 *  * if you want the something at the last position , consider the size-1 position.
 *  * for more efficient expansion we resize the array by 2 times.
 * */
public class AList<Honor>  implements GenericList<Honor>
{


    private Honor[] items;
    private int size;

    public AList() {
        size = 0;
        items = (Honor[]) new Object[10];
    }

    public AList(Honor it) {
        // well we don't need too much space from scratch.
        items = (Honor[]) new Object[10];
        addLast(it);
    }

    @Override
    public  void addFirst(Honor it)
    {
        for(int i=size;i>0;i--)
            items[i]=items[i-1];
        items[0]=it;
        size++;
    }

    @Override
    public void addLast(Honor it) {
        if(items.length==size)
        {
            resize();
        }
        items[size++] = it;
    }

    public void resize() {
        Honor[] arr = (Honor[]) new Object[size * 2];
        System.arraycopy(items, 0, arr, 0, size);
        items = arr;
    }

    public Honor removeLast() {
        // we don't need to really delete the element since when using it you won't consider the missing element
        Honor value=items[size-1];
        size--;
        return value;
    }

    @Override
    public Honor get(int i) {
        return items[i];
    }

    @Override
    public Honor getFirst()
    {
        return  items[0];
    }

    @Override
    public  Honor getLast()
    {
        return items[size-1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear()
    {
        size=0;
        items=(Honor[])  new Object[10];
    }

}
