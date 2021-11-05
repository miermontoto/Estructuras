package estDatos;

/**
 * TDA de números racionales. Números de la forma {@code a/b} con
 * {@code a} y {@code b} enteros ({@code b≠0}).
 *
 * <p>El signo de un número racional coincidirá siempre con el
 * signo del numerador</p>
 */
public interface Racional extends Comparable<Racional> {

    /**
     * Retorna el máximo común divisor de dos enteros dados
     * positivos.
     *
     * @param a el primer entero
     * @param b el segundo entero
     * @return el máximo común divisor de los enteros especificados
     * @throws IllegalArgumentException si alguno de los enteros
     * dados no es positivo
     */
    static int mcd(final int a, final int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException();
        }

        int n1 = a;
        int n2 = b;

        while (n2 != 0) {
            int temp = n1;
            n1 = n2;
            n2 = temp % n2;
        }

        return n1;
    }

    /**
     * Retorna el numerador de este racional.
     *
     * @return el numerador del racional
     */
    int numerador();

    /**
     * Retorna el denominador de este racional.
     *
     * @return el denominador del racional
     */
    int denominador();

    /**
     * Cambia el valor de este racional a una fracción
     * equivalente e irreducible (operación opcional).
     */
    default void reduce() {
        throw new UnsupportedOperationException();
    }
    
    default void setNumerador(int i) {
        throw new UnsupportedOperationException();
    }
    
    default void setDenominador(int i) {
        throw new UnsupportedOperationException();
    }
    
    @Override
	public default int compareTo(Racional o) {
		double thisRacional = (double) this.numerador() / this.denominador();
		double oRacional = (double) o.numerador() / o.denominador();
		
		if(thisRacional > oRacional) return 1;
		else if(thisRacional < oRacional) return -1;
		else return 0;
	}

}
