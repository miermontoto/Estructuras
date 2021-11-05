package app;

import static java.lang.System.out;
import java.util.function.Consumer;
import java.util.function.Predicate;

import estDatos.IteratorChildren;
import estDatos.Tree;
import estDatos.TreeList;

public class App<E> {
	
	public static <E> void preorder(Tree<E> tree,
			Consumer<? super Tree<E>> block, Predicate<? super Tree<E>> p) {
		IteratorChildren<Tree<E>> itr = tree.iteratorChildren();

		// tratar la raíz
		if (p.test(tree)) {
			block.accept(tree);
		}		
		
		// los subárboles hijos de la raíz en preorden
		while (itr.hasNext()) {
			preorder(itr.next(), block, p);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		TreeList<Character> tf = new TreeList<>('f');
		TreeList<Character> tg = new TreeList<>('g');
		TreeList<Character> th = new TreeList<>('h');
		TreeList<Character> ti = new TreeList<>('i');
		TreeList<Character> tj = new TreeList<>('j');
		TreeList<Character> tk = new TreeList<>('k');
		TreeList<Character> tl = new TreeList<>('l');
		TreeList<Character> tm = new TreeList<>('m');
		TreeList<Character> tn = new TreeList<>('n');
		TreeList<Character> te = new TreeList<>('e', tf, tg, th);
		TreeList<Character> td = new TreeList<>('d', ti, tj);
		TreeList<Character> tc = new TreeList<>('c', te, tk, tl);
		TreeList<Character> tb = new TreeList<>('b', td, tm, tn);
		TreeList<Character> ta = new TreeList<>('a', tb, tc);
		
		fullPrintTree(ta);
		replace(ta, 'e', 'x');
		fullPrintTree(ta);	
	}
	
	public static void fullPrintTree(Tree<Character> ta) {
		out.print("Recorrido en preorden: ");
		Tree.preorder(ta, out::print, ch -> true);
		out.printf("%nRecorrido en inorden: ");
		Tree.inorder(ta, out::print, ch -> true);
		out.printf("%nRecorrido en postorden: ");
		Tree.postorder(ta, out::print, ch -> true);
	}
	
	public static <E> void replace(Tree<E> ta, E a, E b) {
		preorder(ta, tree -> tree.setLabel(b),
					tree -> tree.label().equals(a)); 
	}
	
}
