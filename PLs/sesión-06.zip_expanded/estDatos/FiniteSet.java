package estDatos;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * Tipo de dato modificable de conjuntos finitos. Los conjuntos
 * sólo contendrán elementos de un rango dado. Por tanto, el 
 * conjunto universal (tiene todos los elementos posibles) está
 * constituido por todos los valores de dicho rango.
 */
public class FiniteSet<E> extends AbstractSet<E> {
	private Range<E> universal;		// conjunto universal
	private List<Boolean> vbool;	// secuencia de booleanos
	private int numItems;			// número de elementos del conjunto
	
	/**
	 * Crea un conjunto finito para el rango especificado
	 * que contiene los  elementos dados.
	 * @param r el rango asociado
	 * @param items los elementos del conjunto
	 */
	@SafeVarargs
	public FiniteSet(Range<E> r, E...items) {
		vbool = new ArrayList<>();
		numItems = 0;
		
		// primero se rellena de valores falsos.
		for(int i = 0; i < r.size(); i++) vbool.set(i, false);
		// una vez que se comprueba que el item exista, se cambia su valor a true.
		for(E e : items) vbool.set(r.eToInt(e), true); numItems++;
	}
	
	/**
	 * Crea un conjunto finito copia del especificado.
	 * @param c el conjunto finito a copiar
	 */
	public FiniteSet(FiniteSet<E> c) {
		this.numItems = c.size();
		this.vbool = new ArrayList<>(c.vbool);
		this.universal = c.universal;
	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorImp();
	}

	@Override
	public int size() {
		return this.numItems;
	}
	
	@Override
	public boolean contains(Object e) {
		return vbool.get(universal.eToInt((E) e));
	}
	
	@Override
	public boolean add(Object o) {
		if(((E) o).getClass().equals(universal.iterator().next().getClass())) {
			vbool.set(universal.eToInt((E) o), true);
			numItems++;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean remove(Object e) {
		if(this.contains(e)) {
			vbool.set(universal.eToInt((E) e), false);
			numItems--;
			return true;
		}
		return false;
		
	}
	
	class IteratorImp implements Iterator<E> {
		int remainingTrueItems = numItems;
		int currentItemIndex = 0;
		int lastReturnedItemIndex;
		Iterator<E> itr = universal.iterator();

		@Override
		public boolean hasNext() {
			return remainingTrueItems != 0;
		}

		@Override
		public E next() {
			if(!hasNext()) throw new NoSuchElementException();
			
			E temp = itr.next();
			while(!vbool.get(currentItemIndex)) {temp = itr.next(); currentItemIndex++;}
			lastReturnedItemIndex = currentItemIndex;
			remainingTrueItems--;
			return temp;
		}
		
		@Override
		public void remove() {
			vbool.set(lastReturnedItemIndex, false);
			numItems--;
		}
		
	}
		
} // class FiniteSet
