public interface PeekIterator<E> extends Iterator<E> {
  E peek(); // retorna el item que retornará  itr.next();
}

class PeekingIterator implements PeekIterator<E> {
  private E itemToReturn;
  Iterator<E> itr;
  boolean current;

  public PeekingIterator(Iterator<E> itr) {
    this.itr = itr;
    hasCurrent = false;
    current = null;
  }

  public E next() {
    E temp;
    // if(!hasNext()) throw new UnsupportedOperationException();
    if(!hasCurrent) temp = itr.next();
    else temp = current;
    hasCurrent = false;
    return temp;
  }

  public boolean hasNext() {
    return itr.hasNext();
  }

  public E peek() {
    // if(!hasNext()) throw new UnsupportedOperationException();
    if(!hasCurrent) current = itr.next(); hasCurrent = true;
    return current;
  }
}
