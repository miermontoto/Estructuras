package ex1pl1aUO283319;

import java.util.AbstractCollection;
import java.util.ArrayList; // se pueden utilizar tanto linked como array list.
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import static java.lang.System.out;

public class FilteredBag<E> extends AbstractCollection<E> {
	
	List<E> data;
	Predicate<? super E> p;
	
	public FilteredBag() {
		this((Predicate<? super E>) null); // se necesita un cast para que no sea ambiguo.
	}
	
	public FilteredBag(Predicate<? super E> p) {
		data = new LinkedList<>();
		this.p = p;
	}
	
	public FilteredBag(Collection<? extends E> c, Predicate<? super E> p) {
		this(p);
		this.addAll(c);
	}
	public FilteredBag(Collection<? extends E> c) {
		this(c, null);
	}
	
	public FilteredBag(FilteredBag<E> f) {
		this(f, f.p);
	}	
	
	public FilteredBag(Predicate<? super E> p, final E...c) {
		this(p);
		for(E e : c) add(e);
	}
	
	public FilteredBag(final E...c) {
		this(null, c);
	}
	
	@Override
	public boolean add(E e) {
		if(p == null) return data.add(e); // si no hay Predicate, se añade directamente.
		else if(p.test(e)) return data.add(e); // si lo hay, se comprueba el filtro antes de añadir.
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return data.iterator();
	}
	
	@Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) modified |= this.add(e);
        return modified;
    }

	@Override
	public int size() {
		return data.size();
	}

}
