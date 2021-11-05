package app;

import estDatos.Racional;
import estDatos.RacionalMod;
import estDatos.RacionalNoMod;

/**
 * Clase para el programa principal sobre racionales.
 */
public final class App {
	
    private App() {
    }

    /**
     * Programa principal.
     *
     * @param args argumentos del programa
     */
    public static void main(String[] args) {
        final Racional r1 = new RacionalMod(2, 6);
        final Racional r2 = new RacionalNoMod(r1);

        System.out.printf("Racional r1: %s\n", r1);
        System.out.printf("Racional r2: %s\n", r2);

        r1.reduce();
        System.out.printf("Racional r1: %s\n", r1);
        System.out.printf("¿r1=r2? %b\n", r1.equals(r2));
        r2.reduce();
        System.out.printf("Racional r1: %s\n", r2);
    }
}
