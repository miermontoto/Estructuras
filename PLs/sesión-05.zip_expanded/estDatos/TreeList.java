package estDatos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TreeList<E> implements Tree<E> {
	
	E labelRoot;
	List<Tree<E>> children = new LinkedList<>();
	
	public TreeList(E e) {labelRoot = e;}
	
	public TreeList(E e, Tree<E>...trees) {
		labelRoot = e;
		c.addAll(trees);
	}
	
	public TreeList(E e, List<Tree<E>> c) {
		labelRoot = e;
		c.addAll(children);
	}

	public TreeList(Tree<E> t) {
		labelRoot = label();
		Iterator<Tree<E>> itr = t.iteratorChildren();
		while(itr.hasNext()) children.add(itr.next());
		
	}

	@Override
	public boolean isLeaf() {
		return children.size() == 0;
	}

	@Override
	public E label() {
		return labelRoot;
	}
	
	@Override
	public void setLabel(E e) {
		this.labelRoot = e;
	}

	@Override
	public IteratorChildren<Tree<E>> iteratorChildren() {
		return new IteratorChildrenImp();
	}
	

	
	class IteratorChildrenImp implements IteratorChildren<Tree<E>> {
		
		int index = 0;

		@Override
		public boolean hasNext() {
			return index < children.size();
		}

		@Override
		public Tree<E> next() {
			return children.get(index++);
		}
	}

}
