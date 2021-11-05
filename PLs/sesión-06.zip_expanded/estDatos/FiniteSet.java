package estDatos;

import java.util.AbstractSet;
import java.util.List;


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

	}
	
	/**
	 * Crea un conjunto finito copia del especificado.
	 * @param c el conjunto finito a copiar
	 */
	public FiniteSet(FiniteSet<E> c) {

	}
		
} // class FiniteSet
