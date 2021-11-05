package estDatos;

import java.util.AbstractQueue;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PriorityQueueList<E> extends AbstractQueue<E> {
	
	List<E> queue = new LinkedList<>();
	Comparator<? super E> cmp = null;
	
	@SuppressWarnings("unchecked")
	private int compare(final E temp, final E temp2) {
		if(this.cmp == null && !(temp instanceof Comparable<?>)) {
			throw new ClassCastException();
		}
		
		return cmp == null ? ((Comparable<E>) temp).compareTo(temp2) : this.cmp.compare(temp, temp2);
	}
	
	public PriorityQueueList() {} // sin comparator
	public PriorityQueueList(Comparator <? super E> c) {cmp = c;}
	
	

	@Override
	public boolean offer(E e) {
		int i = 0;
		E temp;
		boolean check = false;
		while(i < size() && !check) {
			temp = queue.get(i++);
			if(compare(temp, e) == 1) check = true;
		}
		queue.add(i, e);
		return true;
	}

	@Override
	public E poll() {
		return queue.remove(0);
	}

	@Override
	public E peek() {
		return queue.get(0);
	}

	@Override
	public Iterator<E> iterator() {
		return new PersonalQueueIterator();
	}

	@Override
	public int size() {
		return queue.size();
	}
	
	class PersonalQueueIterator implements Iterator<E> {
		private Iterator<E> itr;
		
		private PersonalQueueIterator() {itr = queue.iterator();}
		public boolean hasNext() {return itr.hasNext();}
		public E next() {return itr.next();}
		
	}
}
