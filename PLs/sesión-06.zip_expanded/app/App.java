package app;

import java.util.LinkedList;
import java.util.List;

import estDatos.*;

public class App {

	public static void main(String[] args) {
		Range<Integer> ri = new Range<>(-40, 60);
		List<Integer> i1 = new LinkedList<>();
		for(Integer i : ri) if(i % 7 == 0) i1.add(i);
		FiniteSet<Integer> c0 = new FiniteSet<Integer>(ri, i1.toArray(new Integer[0]));
		mostrarConjunto(c0);
		c0.remove(0);
		c0.remove(7);
		c0.remove(14);
		mostrarConjunto(c0);
		
		Range<Character> rc = new Range<>('a', 'z');
		List<Character> h1 = new LinkedList<>();
		List<Character> h2 = new LinkedList<>();
		h1.add('c');
		h1.add('k');
		h1.add('r');
		h1.add('x');
		h2.add('b');
		h2.add('f');
		h2.add('k');
		h2.add('r');
		h2.add('z');
		FiniteSet<Character> c1 = new FiniteSet<>(rc, h1.toArray(new Character[0]));
		FiniteSet<Character> c2 = new FiniteSet<>(rc, h2.toArray(new Character[0]));
		FiniteSet<Character> c3 = new FiniteSet<>(c1);
		FiniteSet<Character> c4 = new FiniteSet<>(c3);
		FiniteSet<Character> c5 = new FiniteSet<>(c4);
		mostrarConjunto(c1);
		mostrarConjunto(c2);
		mostrarConjunto(c3);
		System.out.printf("?c1 == c3? %s%n", c1.equals(c3));
		System.out.printf("?c2 == c3? %s%n", c2.equals(c3));
		
		// Uni?n
		c3.addAll(c2);
		System.out.print("c3 = c1 uni?n c2: "); mostrarConjunto(c3);
		// Intersecci?n
		c4.retainAll(c2);
		System.out.print("c4 = c1 intersecci?n c2: "); mostrarConjunto(c4);
		// Diferencia
		c5.removeAll(c2);
		System.out.print("c5 = c1 diferencia c2: "); mostrarConjunto(c5);
		
		System.out.printf("?c1 subconjunto c3?: %s%n", c3.containsAll(c1));
		System.out.printf("?c4 subconjunto c1?: %s%n", c1.containsAll(c4));
		System.out.printf("?c5 subconjunto c1?: %s%n", c1.containsAll(c5));
	}
	
	public static <E> void  mostrarConjunto(FiniteSet<E> s) {
		//System.out.print("Contenido del conjunto: ");
		for(E e : s) System.out.printf("%s ", e);
		System.out.printf("(%d elementos)%n", s.size());
	}

}
