package estDatos;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class SortedBag<E> extends BagMod<E> {
	
	private final Comparator<? super E> cmp;
	
	public SortedBag() {super(); cmp = null;}
	
	public SortedBag(final int capacity) {super(capacity); cmp = null;}
	
	public SortedBag(final int capacity,
			final Comparator<? super E> c) {super(capacity); cmp = c;}
	
	public SortedBag(final Collection<? extends E> c) {super(c); cmp = null;}
	
	public SortedBag(final Collection<? extends E> c,
			final Comparator<? super E> a) {super(c); cmp = a;}
	
	public SortedBag(final Comparator<? super E> c) {super(); cmp = c;}
	
	@SuppressWarnings("unchecked")
	private int compare(final E temp, final E temp2) {
		if(this.cmp == null && !(temp instanceof Comparable<?>)) {
			throw new ClassCastException();
		}
		
		return cmp == null ? ((Comparable<E>) temp).compareTo(temp2) : this.cmp.compare(temp, temp2);
	}
	
	@Override
	public Iterator<E> iterator() {
		return new SortedIterator();
	}
	
	class SortedIterator extends IteratorImp {
		
		public E[] temp;
		
		public SortedIterator() {
			
			System.arraycopy(data, 0, temp, 0, size());
			if(!(temp[0] instanceof Comparable<?>) && cmp == null)
				throw new ClassCastException();
			
			boolean check = false;
			while(!check) {
				check = true;
				for(int i = 0; i + 1 < size(); i++) {
					if(compare(temp[i], temp[i+1]) <= 0) {
						E x = temp[i+1];
						temp[i+1] = temp[i];
						temp[i] = x;
						check = false;
					}
						
				}
			}
		}
	}

}
