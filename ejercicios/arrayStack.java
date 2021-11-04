public class ArrayStack<E> extends AbstractQueue<E>  {

    private E[] data;
    private int currentData;
    public static int MIN_CAPACITY = 10;

    public ArrayStack(int n) {
        data = (E[]) new Object[Math.max(n, MAX_CAPACITY)];
        currentData = 0;
    }

    @Override
    public boolean offer(E e) {
        if(data.length == size()) return false;
        if(e == null) return new NullPointerException();

        data[currentData++] = e;
        return true;
      }

    @Override
    public E poll() {
        if(size() == 0) return null;
        return data[currentData--];
    }

    @Override
    public E peek() {
        return size() == 0 ? null : data[size()];
    }

    @Override
    public int size() {
        return currentData;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImp();
    }

    class IteratorImp implements Iterator<E> {
        int index = size();

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public E next() {
            return data[index--];
        }

    }

}
