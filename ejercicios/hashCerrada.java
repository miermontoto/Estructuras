public class hashCerrada {
  private E[] data;
  private int[] state; // 0 = vacío, 1 = ocupado, -1 = borrado.
  public static final int DEFAULT_CAPACITY = 7;
  public static final double DEFAULT_LOAD_FACTOR_LIMIT = 0.5f;
  private static double loadFactorLimit;
  private int numberOfElements;
  private int numberOfDeletions;

  public hashCerrada() {
    this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR_LIMIT);
  }

  public hashCerrada(int c) {
    this(i, DEFAULT_LOAD_FACTOR_LIMIT);
  }

  public hashCerrada(double lf) {
    this(DEFAULT_CAPACITY, d);
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
    int pos = hash(x);
    int i = 1;
    while(state[pos] != 0) {
      rehash(x, i);
      i++;
    }
    data[pos] = x;
    numberOfElements++;
    if(loadFactor() > LOAD_FACTOR_LIMIT) resize();
  }

  private int rehash(E x, int i) {
    return (hash(x) + i) % data.length;
  }

  public E get(int x) {return 0 <= x && x < data.length ? data[x] : null;}

  public boolean contains(E e) {
    int pos = firstEqualOrEmpty(e);

  }

  private int firstEqualOrEmpty(E e) {
    int pos = hash(e);
    int i = 1;
    while(i <= data.length) {
      if(status[pos] == 1 && data[pos] == e || status[pos] == 0) return pos;
      else {pos = rehash(e, i); i++;}}
    }
    throw new RuntimeException("Superado límite de búsqueda de elemento.");
  }

  public boolean remove(E e) {
    int pos = firstEqualOrEmpty(e);
    if(status[pos] != 0) {
        status[pos] = -1;
        numberOfElements--;
        numberOfDeletions++;
        return true;
    }
    return false;
  }
}
