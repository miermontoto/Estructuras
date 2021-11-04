/* Sí que se puede implementar un tipo de dato no modificable
   extendiendo a uno que sí que lo sea, si se hacen inaccesibles
   aquellos métodos que hagan al primer tipo de dato modificable
   en sí. Por este motivo, no hay ninguna razón por la cuál no
   sea posible*/

public class SList<E> {
  List<E> data;

  public SList() {
    data = new LinkedList<>();
  }

  public SList(E primero, SList<E> resto) {
    data = new LinkedList<>(resto.data);
    data.add(0, primero);
  }

  public boolean esVacia() {
    return data.size() == 0;
  }

  public E primero() {
    if(this.esVacia()) throw new NoSuchElementException();
    return data.get(0);
  }

  public SList<E> resto() {
    if(this.esVacia()) throw new NoSuchElementException();
    SList<E> ret = new SList<>(data);
    ret.data.remove(0);
    return ret;
  }
}
