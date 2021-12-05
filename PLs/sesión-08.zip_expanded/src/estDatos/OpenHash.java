package estDatos;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class OpenHash<E> extends AbstractSet<E> {
	private ArrayList<TreeSet<E>> table;
	private LinkedList<E> elementList;
	private int tableSize;
	private int elements;
	private double loadFactorLimit;
	public static final double DEFAULT_LOAD_FACTOR_LIMIT = 0.75;
	public static final int DEFAULT_TABLE_SIZE = 11;
	
	public OpenHash() {
		this(DEFAULT_TABLE_SIZE, DEFAULT_LOAD_FACTOR_LIMIT);
	}
	
	public OpenHash(int initialCapacity) {
		this(initialCapacity, DEFAULT_LOAD_FACTOR_LIMIT);
	}
	
	public OpenHash(int initialCapacity, double loadFactor) {
		loadFactorLimit = loadFactor;
		tableSize = initialCapacity;
		table = new ArrayList<>();
		elementList = new LinkedList<>();
		elements = 0;
	}

	public OpenHash(OpenHash<E> ts) {
		loadFactorLimit = ts.loadFactorLimit;
		tableSize = ts.tableSize;
		table = new ArrayList<>(ts.table);
		elementList = new LinkedList<>(ts.elementList);
		elements = ts.elements;
	}
	
	private int hash(E e) {
		return e.hashCode() % tableSize;
	}
	
	@Override
	public boolean contains(Object e) {
		try {
			return table.get(hash((E) e)).contains(e); 
		} catch(Exception abc) {return false;}
	}
	
	@Override
	public boolean remove(Object a) {
		try {
			E e = (E) a;
			if(!this.contains(e)) return false;
			elementList.remove(e);
			table.get(hash(e)).remove(e);
			return true;	
		} catch (Exception abc) {return false;}
	}
	
	@Override
	public boolean add(E e) {
		int hash = hash(e);
		if(this.contains(e)) return false;
		if(((elements + 1) / tableSize) >= loadFactorLimit) resize();
		table.get(hash).add(e);
		elementList.add(e);
		elements++;
		return true;
	}
	
	private void resize() {
		ArrayList<TreeSet<E>> temp = new ArrayList<>();
		tableSize *= 2;
		while(!esPrimo(tableSize)) tableSize++;
		for(E e : elementList) temp.get(hash(e)).add(e);
		table = temp;
	}
	
	private static boolean esPrimo(int x) {
		if(x == 1) return true;
		for(int i = 2; i <= x / 2; i++) if(x % i == 0) return false;
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return tableSize;
	}

	public String printTable() {
		String res = "";
		for(int i = 0; i < tableSize; i++) {
			res += String.format("%d: ", i);
			for(E e : table.get(i)) res += String.format("%s ", e);
		}
		return res;
	}

}
