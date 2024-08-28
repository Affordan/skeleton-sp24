/*
 *  Before using this class you're suggested to read this README file
 *  * DEVELOP WHAT YOU NEED WHEN ENCOUNTERING PRO. DO NOT THINK TOO MUCH BEFORE *
 *  * if you want to add some to the last position put it at size.
 *  * if you want the something at the last position , consider the size-1 position.
 *  * for more efficient expansion we resize the array by 2 times.
 * */
package AList;

public class AList<Honor> {


    private Honor[] items;
    private int size;

    public AList() {
        size = 0;
        items = null;
    }

    public AList(Honor it) {
        // well we don't need too much space from scratch.
        items = (Honor[]) new Object[10];
        addLast(it);
    }

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

    public void removeLast() {
        // we don't need to really delete the element since when using it you won't consider the missing element
        size--;
    }

    public Honor get(int i) {
        return items[i];
    }

    public  Honor getLast()
    {
        return items[size-1];
    }

    public int size() {
        return size;
    }

}
