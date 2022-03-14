package estDatos;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class SetNoMod<E> extends AbstractCollection<E> {
	
	protected final List<E> data;
	
	/*
	 * Los elementos se ordenan desde un primer momento,
	 * puesto que el algoritmo de selección es muy costoso
	 * y no tendría sentido ordenar los elementos en cada
	 * nuevo iterador.
	 */
	@SuppressWarnings("unchecked")
	public SetNoMod(final Collection <? super E> c) {
		var itr = c.iterator();
		data = new LinkedList<>();
		int added = -1;

		while(itr.hasNext()) {
			var temp = itr.next();
			boolean check = true;
			for(int i = 0; i < added && added >= 0; i++) {
				if(this.data.get(i) == temp) check = false;
			}
			if(check) this.data.add((E) temp);
		}
	}

	@Override
	public Iterator<E> iterator() {return new IteratorImp();}

	@Override
	public int size() {return this.data.size();}

	class IteratorImp implements java.util.Iterator<E> {

		
		private int index = 0;
		@Override
		public boolean hasNext() {
			return !data.isEmpty();
			/*
			 * puesto que se va vaciando la cola, si
			 * sigue habiendo algún elemento en la lista
			 * significa que todavía quedan elementos dentro.
			 */
		}

		@Override
		public E next() {
			if(!hasNext()) throw new NoSuchElementException();
			else return data.get(index++);
		}
	}

}
