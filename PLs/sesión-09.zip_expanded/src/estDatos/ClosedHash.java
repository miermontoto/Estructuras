package estDatos;

import java.util.Collection;
import java.util.Iterator;

public class ClosedHash<E> {
	private E[] data;
	private int[] status; // 0 = vacío, 1 = borrado, 2 = ocupado.
	public static final int DEFAULT_CAPACITY = 11;
	public static final double DEFAULT_LOAD_FACTOR_LIMIT = 0.5f;
	private static double loadFactorLimit;
	private int numberOfElements;
	private int numberOfDeletions;

	public ClosedHash() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR_LIMIT);
	}

	public ClosedHash(int c) {
		this(c, DEFAULT_LOAD_FACTOR_LIMIT);
	}

	public ClosedHash(double lf) {
		this(DEFAULT_CAPACITY, lf);
	}

	public ClosedHash(int c, double lf) {
		data = (E[]) new Object[c];
		status = new int[c];
		numberOfElements = 0;
		numberOfDeletions = 0;
		loadFactorLimit = lf;
	}
	
	public ClosedHash(ClosedHash tc) {
		data = (E[]) tc.data;
		status = tc.status;
		numberOfElements = tc.numberOfElements;
		numberOfDeletions = tc.numberOfDeletions;
		loadFactorLimit = tc.loadFactorLimit;
	}

	private int hash(E x) {
		return rehash(x, 0);
	}

	private double loadFactor() {
		return ((double) numberOfElements + numberOfDeletions) / (double)status.length;
	}

	public boolean add(E x) {
		if(this.contains(x)) return false;
		int pos = firstErasedOrEmpty(x);
		data[pos] = x;
		if(status[pos] == 1) numberOfDeletions--;
		status[pos] = 2;
		numberOfElements++;
		if(loadFactor() > loadFactorLimit) resize();
		return true;
	}
	
	public ClosedHash(Collection<? extends E> c) {
		addAll(c);
	}
	
	public boolean addAll(Collection<? extends E> c) {
		boolean check = true;
		for(E e : c) check &= add(e);
		return check;
	}
	
	public String printTable() {
		String res = "";
		for(int i = 0; i < status.length; i++) 
			res += String.format("%d: %s%n", i, status[i] == 2 ? data[i] : "-");
		return res;
	}

	private void resize() {
		int newSize = status.length;
		while(!esPrimo(newSize)) newSize++;
		E[] tempData = data;
		data = (E[]) new Object[newSize];
		status = new int[newSize];
		boolean check = true;
		for(E e : tempData) check &= add(e);
		System.out.printf("Resize completado %s.", check ? "correctamente" : "con errores");
	}

	private static boolean esPrimo(int x) {
		if(x == 1) return true;
		for(int i = 2; i <= x / 2; i++) if(x % i == 0) return false;
		return true;
	}

	public Iterator<E> iterator() {
		return new IteratorImp();
	}

	private int firstEqualOrErasedOrEmpty(E e) {
		int pos = rehash(e, 0); // == hash(e)
		int i = 1;
		while(i < data.length) {
			if(status[pos] == 2 && data[pos] == e || status[pos] == 0 || status[pos] == 1) return pos;
			else {pos = rehash(e, i); i++;}
		}
		throw new RuntimeException("Superado límite de búsqueda de elemento.");
	}

	private int rehash(E x, int i) {
		return (x.hashCode() + i) % data.length;
	}

	public E get(int x) {return 0 <= x && x < data.length ? data[x] : null;}

	public boolean contains(E e) {
		try {
			int pos = firstEqualOrEmpty(e);
			return status[pos] == 2;
		} catch (Exception abc) {return false;}

	}

	private int firstErasedOrEmpty(E e) {
		int pos = hash(e);
		int i = 1;
		while(i < data.length) {
			if(status[pos] != 2) return pos;
			else {pos = rehash(e, i); i++;}
		}
		throw new RuntimeException("Superado límite de búsqueda de elemento.");
	}

	private int firstEqualOrEmpty(E e) {
		int pos = hash(e);
		int i = 1;
		while(i < data.length) {
			if(status[pos] == 2 && e.equals(data[pos]) || status[pos] == 0) return pos;
			else {pos = rehash(e, i); i++;}
		}
		throw new RuntimeException("Superado límite de búsqueda de elemento.");
	}

	public boolean remove(E e) {
		int pos = firstEqualOrEmpty(e);
		if(status[pos] != 0) {
			status[pos] = 1;
			numberOfElements--;
			numberOfDeletions++;
			return true;
		}
		return false;
	}

	class IteratorImp implements Iterator<E> {
		int pos = 0;
		int readElements = 0;

		public boolean hasNext() {
			return readElements < numberOfElements;
		}

		public E next() {
			if(!hasNext()) throw new UnsupportedOperationException();
			while(status[pos] != 2) pos++;
			readElements++;
			return data[pos];
		}
	}
}
