public class hashCerrada {
  private E[] data;
  private int[] state; // 0 = vacío, 1 = borrado, 2 = ocupado.
  public static final int DEFAULT_CAPACITY = 7;
  public static final double DEFAULT_LOAD_FACTOR_LIMIT = 0.5f;
  private static double loadFactorLimit;
  private int numberOfElements;
  private int numberOfDeletions;

  public hashCerrada() {
    this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR_LIMIT);
  }

  public hashCerrada(int c) {
    this(c, DEFAULT_LOAD_FACTOR_LIMIT);
  }

  public hashCerrada(double lf) {
    this(DEFAULT_CAPACITY, lf);
  }

  public hashCerrada(int c, double lf) {
    data = new E[c];
    state = new int[c];
    numberOfElements = 0;
    numberOfDeletions = 0;
    loadFactorLimit = lf;
  }

  private int hash(E x) {
    return x.hashCode() % data.length;
  }

  private float loadFactor() {
    return (numberOfElements + numberOfDeletions) / data.length;
  }

  public boolean add(E x) {
    if(this.contains(x)) return false;
    int pos = firstEqualOrErasedOrEmpty(e);
    data[pos] = x;
    if(status[pos] == 1) numberOfDeletions--;
    status[pos] = 2;
    numberOfElements++;
    if(loadFactor() > LOAD_FACTOR_LIMIT) resize();
    return true;
  }

  public Iterator<E> iterator() {
    return new IteratorImp<E>();
  }

  private int firstEqualOrErasedOrEmpty(E e) {
    int pos = rehash(e, 0); // == hash(e)
    int i = 1;
    while(i < data.length) {
      if(status[pos] == 2 && data[pos] == e || status[pos] == 0 || status[pos] == 1) return pos;
      else {pos = rehash(e, i); i++;}
    }
    throw new RuntimeException("Superado límite de búsqueda de elemento.");
  }

  private int rehash(E x, int i) {
    return (hash(x) + i) % data.length;
  }

  public E get(int x) {return 0 <= x && x < data.length ? data[x] : null;}

  public boolean contains(E e) {
    try {
      int pos = firstEqualOrEmpty(e);
      return status[pos] == 2;
    } catch (Exception abc) {return false;}

  }

  private int firstErasedOrEmpty(E e) {
    int pos = hash(e);
    int i = 1;
    while(i < data.length) {
      if(status[pos] != 2) return pos;
      else {pos = rehash(e, i); i++;}
    }
    throw new RuntimeException("Superado límite de búsqueda de elemento.");
  }

  private int firstEqualOrEmpty(E e) {
    int pos = hash(e);
    int i = 1;
    while(i < data.length) {
      if(status[pos] == 2 && e.equals(data[pos]) || status[pos] == 0) return pos;
      else {pos = rehash(e, i); i++;}
    }
    throw new RuntimeException("Superado límite de búsqueda de elemento.");
  }

  public boolean remove(E e) {
    int pos = firstEqualOrEmpty(e);
    if(status[pos] != 0) {
        status[pos] = 1;
        numberOfElements--;
        numberOfDeletions++;
        return true;
    }
    return false;
  }

  class IteratorImp implements Iterator<E> {
    int pos = 0;
    int readElements = 0;

    public boolean hasNext() {
      return readElements < numberOfElements;
    }

    public E next() {
      if(!hasNext()) throw new UnsupportedOperationException();
      while(status[pos] != 2) pos++;
      readElements++;
      return data[pos];
    }
  }
}
