package 三表栈队列;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2018/4/27
 * \* Time: 14:55
 * \* Description:
 * \
 */
public class MyArrayList<AnyType> implements Iterable<AnyType>{
    @Override
    public Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private AnyType[] theItems = (AnyType[]) new Object[]{};

    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size()==0;
    }

    public void trimToSize() {

    }

    public AnyType get(int idx) {
        if (idx < 0 || idx >= theSize) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    public AnyType set(int idx, AnyType newVal) {
        if (idx < 0 || idx >= theSize) {
            throw new ArrayIndexOutOfBoundsException();
        }
        AnyType old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        System.arraycopy(old, 0, theItems, 0, size());
    }

    public void add(AnyType anyType) {
        add(size(), anyType);
    }

    public void add(int idx, AnyType anyType) {
        if (theItems.length == size()) {
            ensureCapacity(2*size()+1);//扩展
        }
        System.arraycopy(theItems, idx, theItems, idx + 1, theSize - idx);
        theItems[idx] = anyType;
        theSize++;
    }

    public AnyType remove(int idx) {
        AnyType removeItem = theItems[idx];
        System.arraycopy(theItems,idx,theItems,idx-1,theSize-idx);
        theSize--;
        return removeItem;
    }

    private class ArrayListIterator implements Iterator<AnyType>{

        private int current = 0;

        public boolean hasNext() {
            return current < size();
        }

        @Override
        public AnyType next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(current);
            current--;
        }

    }
    @Override
    public void forEach(Consumer<? super AnyType> action) {

    }
    @Override
    public Spliterator<AnyType> spliterator() {
        return null;
    }
}
