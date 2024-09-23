import java.util.List;
import java.lang.Math.*;

public class ArrayDeque61B<T> implements Deque61B<T> {

    private int size_;
    private int capacity;
    private T[] items;
    private int head;
    private int tail;
    private int middle;

    public ArrayDeque61B() {
        size_ = 0;
        capacity = 8;
        items = (T[]) new Object[8];
        middle = capacity / 2;
        head = middle - 1;   //let head in the middle of the array.
        tail = middle;
    }

    /**
     * Add {@code x} to the front of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        items[head] = x;
        head = Math.floorMod(head - 1, capacity);
        size_++;
        if (isFull())
            resize();
    }

    /**
     * Add {@code x} to the back of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        items[tail] = x;
        tail = Math.floorMod(tail + 1, capacity);
        size_++;
        if (isFull())
            resize();
    }

    /**
     * Returns a List copy of the deque. Does not alter the deque.
     *
     * @return a new list copy of the deque.
     */
    @Override
    public List<T> toList() {

        return List.of();
    }

    /**
     * Returns if the deque is empty. Does not alter the deque.
     *
     * @return {@code true} if the deque has no elements, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size_ == 0;
    }

    /**
     * Returns if the deque is full.
     *
     * @return {@code true} if the deque is full,{@code false}  otherwise.
     */
    private boolean isFull() {
        //return head==tail;  //while head equals tail,the deque has no empty place.
        return size_ == capacity;
    }

    /**
     * If the deque is full, expand it to a double size deque.
     * <p>
     * A tricky problem is to copy data appropriately to new array.
     *
     * @author Affordan
     */

    private void resize() {
        int newCapacity = 2 * capacity;
        int newMiddle = newCapacity / 2;
        int newHead = newMiddle - 1;
        int newTail = newMiddle;
        T[] newItems = (T[]) new Object[newCapacity];

        int tmp = middle - 1;
        while (tmp != head) {
            newItems[newHead] = items[tmp];
            tmp = Math.floorMod(tmp - 1, capacity);
                /*Actually  just write head-- is enough
             * cause the total capacity is 2 times of original capacity.
             * */
            newHead = Math.floorMod(newHead - 1, newCapacity);

        }

        tmp = middle;
        while (tmp != tail) {
            newItems[newTail] = items[tmp];
            tmp=Math.floorMod(tmp+1,capacity);
            newTail= Math.floorMod(newTail+1,newCapacity);

        }

        capacity = newCapacity;
        middle = newMiddle;
        head = newHead;
        tail = newTail;
        items=newItems;
    }


    /**
     * Returns the size of the deque. Does not alter the deque.
     *
     * @return the number of items in the deque.
     */
    @Override
    public int size() {
        return size_;
    }

    public int getCapacity()
    {
        return capacity;
    }

    /**
     * Remove and return the element at the front of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeFirst() {
        return null;
    }

    /**
     * Remove and return the element at the back of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeLast() {
        return null;
    }

    /**
     * The Deque61B abstract data type does not typically have a get method,
     * but we've included this extra operation to provide you with some
     * extra programming practice. Gets the element, iteratively. Returns
     * null if index is out of bounds. Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    @Override
    public T get(int index) {
        return null;
    }

    /**
     * This method technically shouldn't be in the interface, but it's here
     * to make testing nice. Gets an element, recursively. Returns null if
     * index is out of bounds. Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    @Override
    public T getRecursive(int index) {
        return null;
    }
}
