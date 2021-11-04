public class Tupla extends AbstractList<Object> {
  List<Object> data;

  public Tupla() {
    data = new ArrayList<>();
  }

  public Tupla(Object ... o) {
    this();
    for(Object i : o) data.add(i);
  }

  public Tupla(Collection<E> c) {
    if(c instanceof Tupla) data = ((Tupla) c).data;
    else data = new ArrayList<>(c);
  }

  @Override
  public Iterator<Object> iterator() {
    return new IteratorImp();
  }

  @Override
  class IteratorImp implements Iterator<Object> {
    private int index = 0;

    public boolean hasNext() {
      return index < data.size();
    }

    public Object next() {
      if(!hasNext()) return new NoSuchElementException();
      return data.get(index++);
    }
  }

  public static Tupla append(Tupla t1, Tupla t2) {
    List<Object> t = new LinkedList<>(t1);
    t.addAll(t2);
    return new Tupla(t);
  }
}
