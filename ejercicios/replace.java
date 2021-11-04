/**
 * Reemplaza en la lista dada la primera ocurrencia del
 * primer elemento especificado por el segundo.
 * @param l la lista a modificar
 * @param a el elemento a reemplazar
 * @param b el elemento que reemplaza la primera ocurrencia
 * del elemento {@code a} en la lista {@code l}.
 */
public static <E> void replace(List<E> l, E a, E b) {
  ListIterator<E> itr = l.listIterator();
  while(itr.hasNext()) if(itr.next().equals(a)) itr.set(b);
}
