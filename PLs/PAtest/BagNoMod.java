import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public class BagNoMod<E> extends AbstractCollection<E> {
	
	private final E[] data;
	
	public BagNoMod(Collection<? extends E> c) {
		if(c instanceof BagNoMod<?>) {
			BagNoMod<E> other = (BagNoMod<E>) c;
			this.data = other.data;
		} else {
			this.data = (E[]) new Object[c.size()];
			int index = 0;
			for(E e : c) data[index++] = e;
		}
	}
	
	public BagNoMod(int x) {
		if(x > 0) this.data = (E[]) new Object[x];
		else this.data = null;
	}
	
	public BagNoMod(final E...e) {
		this(e.length);
		System.arraycopy(e, 0, this.data, 0, e.length);
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {return data.length;}
}
