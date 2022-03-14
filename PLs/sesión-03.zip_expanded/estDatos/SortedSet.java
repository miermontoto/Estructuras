package estDatos;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class SortedSet<E> extends SetNoMod<E> {
	

	public SortedSet(Collection<? super E> c, Comparator<? super E> cmp) {
		super(c);
		if(cmp != null) Collections.sort(data, cmp);
		else Collections.sort(data, (a,b) -> (((Object) a).compareTo(b)));
	}
}
