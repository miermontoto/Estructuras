public static <E> boolean arbolEspecular(BinaryTree<E> t1, BinaryTree<E> t2) {
  if(t1.isEmpty()) return t2.isEmpty();
  else if (t2.isEmpty()) return false;

  // IteratorChildren<E> itr1 = t1.iteratorChildren();
  // IteratorChildren<E> itr2 = t2.iteratorChildren();

  return especular(t1.left) == especular(t2.right)
    && especular(t1.right) == especular(t2.left)
      && t1.label() == t2.label();
}

public static <E> BinaryTree<E> especular(BinaryTree<E> t) {
  if(t.isEmpty()) return t;
  return new BinaryTreeImp<>(t.label, especular(t.right()), especular(t.left()));
}
