package estDatos;

import java.util.Collection;

public class SetMod<E> extends SetNoMod<E> {

	public SetMod(Collection<? super E> c) {
		super(c);
	}
	
	@Override
	public boolean add(final E e) {
		boolean check = true;
		var itr = this.iterator();
		for(E a: data) {
			if(a == e) check = false;
		}
		if(check) data.add(e);
		return check;
	}

}
