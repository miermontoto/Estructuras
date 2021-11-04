class QueueLIFOIterator1 implements Iterator<E> {
  private int index = data.size();

  public boolean hasNext() {
    return index >= 0;
  }

  public E next() {
    if(!hasNext()) throw new NoSuchElementException();
    return data.get(index--);
  }
}

class QueueLIFOIterator2 implements Iterator<E> {
  private ListIterator<E> itr = data.listIterator(data.size());

  public boolean hasNext() {
    return itr.hasPrevious();
  }

  public E next() {
    return itr.previous();
  }
}

/* A la pregunta de cuál de las dos opciones es mejor,
  al parecer es la segunda porque es un iterador más abstracto que
  no depende de la implementación de la lista, solo de su iterador
  personal, por lo que tampoco se depende del tipo de lista que se
  esté utilizando.*/
