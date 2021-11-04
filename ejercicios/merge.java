public static <E> LinkedList<E> merge(LinkedList<E> l1, LinkedList<E> l2,
  Comparator<? super E> cmp) {
  ListIterator<E> itr1 = l1.listIterator();
  ListIterator<E> itr2 = l2.listIterator();
  List<E> data = new LinkedList<>();
  boolean advanceFirst = true, advanceSecond = true;
  E val1, val2;

  while(itr1.hasNext() && itr2.hasNext()) {
    if(advanceFirst) val1 = itr1.next();
    if(advanceSecond) val2 = itr2.next();
    advanceFirst = false;
    advanceSecond = false;

    if(cmp.compare(val1, val2) > 0) {
      data.addLast(val2);
      advanceSecond = true;
    } else if(cmp.compare(val1, val2) < 0) {
      data.addLast(val1);
      advanceFirst = true;
    } else {
      data.addLast(val1);
      advanceFirst = true;
      advanceSecond = true;
    }
  }

  while(itr1.hasNext()) data.addLast(itr1.next());
  while(itr2.hasNext()) data.addLast(itr2.next());
  return data;
}
