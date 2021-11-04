public class CNoMod<E> extends AbstractCollection<E> {
  private List<E> data;

  public CNoMod(Collection<? extends E> c) {
    if(c instanceof CNoMod<?>) this.data = ((CNoMod<E>) c).data;
    else {
      data = new LinkedList<>();
      for(E e : c) if(!this.contains(e)) this.data.add(e);
    }
  }
}

public class CMod<E> extends AbstractCollection<E> {
  private List<E> data;

  public CMod(Collection<? extends E> c) {
    this.data = new LinkedList<>();
    this.addAll(c);
  }
}
