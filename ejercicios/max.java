public static <E> maxI(Iterable<E> c, Comparator<? super E> cmp) {
  Iterator<E> itr = c.iterator();
  if(!itr.hasNext()) return null;

  E max = itr.next();
  while(itr.hasNext()) {
    var temp = itr.next();
    if(cmp.compare(temp, max) > 0) max = temp;
  }

  return max;
}

public static <E extends Comparable<? super E>> E maxII(Iterable<E> c) {
  return maxI(c, (a, b) -> a.compareTo(b));
}

public static Collection<Integer> maxList(Collection<Collection<Integer>> cc) {
  return maxI(cc, (c1, c2) -> collectionSuma(c1) - collectionSuma(c2));
}

private static int collectionSuma(Collection<Integer> next) {
    int suma = 0;
    for(int i : next) suma += i;
    return suma;
}
