import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class SingleEndedList<E> implements List<E> {
	private Node<E> head;
	
	public SingleEndedList(Node<E> e) {
		this.head = e;
	}

	public SingleEndedList() {head = null;}

	public Node<E> node(int index) {
		ListIterator<E> itr = listIterator();
		while(index > 1) {
			itr.next();
			index--;
		}
		return itr.next();
	}
	
	public void linkFirst(Node<E> e) {
		var temp = head;
		head = e;
		e.setNext(temp);
	}
	
	public static <E> List<E> append(final List<E> l1, final List<E> l2) {
		List<E> l0 = new LinkedList<>(l1);
		//List<E> l0 = l1;
		l0.addAll(l2);
		return l0;
	}
	
	public List<E> appendIndex(int index, List<E> l1, List<E> l2) {
		List<E> l0 = null;
		ListIterator<E> itr = l1.listIterator();
		while(index > 0 && itr.hasNext()) {
			l0.add(itr.next());
		}
		
		return l0;
	}
	
	public Node<E> unlink(Node<E> e) {
		var temp = e.getNext();
		e.setNext(temp.getNext());
		return temp;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isEmpty() {
		return head == null;
	}


	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ListIterator<E> listIterator(int index) {
		return new ListItr();
	}


	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class ListItr implements ListIterator<E> {
		protected Node<E> lastReturned;
		protected Node<E> next = head;
		protected int nextIndex = 0;
		
		@Override
		public boolean hasNext() {
			return lastReturned == null ? head == null ? false : head.getNext() == null : lastReturned.getNext() != null;
		}
		
		@Override
		public E next() {
			var temp = next.getData();
			lastReturned = next;
			next = next.getNext();
			return (E) temp;
		}
		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public E previous() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public void remove() {
			if (lastReturned == null) throw new ClassCastException();
			lastReturned.setNext(next.getNext());
			var temp = next;
			next = next.getNext();
			temp.setNext(null);
			nextIndex--;
		}
		@Override
		public void set(E e) {
			if (lastReturned == null) throw new ClassCastException();
			var temp = lastReturned.getNext();
			lastReturned.setData(e);
		}
		@Override
		public void add(E e) {
			// TODO Auto-generated method stub
			
		}
	}
}
