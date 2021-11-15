public static Map<Integer, Integer> sparseVector(int[] x) {
  return sparseVector(x, 0);
}

public <E> static Map<E, E> sparseVector(E[] x, E n) {
  Map<E, E> res = new TreeMap<>();
  for(int i = 0; i < x.length; i++) if(!(n.equals((E) E[i]))) res.add(i, x[i]);
  return res;
}

public static Map<Integer, Map<Integer, Integer>> sparseMatrix(int[][] x) {
  return sparseMatrix(x, 0);
}

public <E> static Map<E, Map<E, E>> sparseMatrix(E[][] x, E n) {
  Map<E, Map<E, E>> res = new TreeMap<>();
  for(int i = 0; i < x.length; i++) {
    Map<E, E> res2 = new TreeMap<>(sparseVector(x[i], n));
    if(res2.isEmpty()) res.add(i, res2);
  }
  return res;
}
