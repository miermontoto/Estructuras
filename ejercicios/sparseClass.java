class SparseVector<E> {
  private Map<Integer, E> data;
  private int d;
  private E nullValue;

  public SparseVector(int d) {
    this.d = d;
    data = new TreeMap<>();
    nullValue = null;
  }

  public SparseVector(int d, int nv) {
    this(d);
    nullValue = nv;
  }

  public E getElement(int pos) {
    return pos < d ? (data.containsKey(pos) ? data.get(pos) : nullValue) : throw new OutOfBoundsException();
  }

  public void setElement(int pos, E x) {
    if(pos >= d) throw new OutOfBoundsException();
    if(x.equals(nullValue)) data.remove(pos);
    data.put(pos, x);
    //if(pos>=d) throw new OutOfBoundsException(); if(!x.equals(nullValue)) data.put(pos, x);
  }

}
