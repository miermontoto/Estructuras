package ex1pl1aUO283319;

import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.System.out;

public class App {

	public static void main(String[] args) {
		// se crea una nueva bolsa con el constructor que incluye el filtro:
		FilteredBag<Integer> bolsaConFiltro = new FilteredBag<>(x -> esPrimo(x));
		
		// se crea una nueva bolsa, sin filtro.
		FilteredBag<Integer> bolsaSinFiltro = new FilteredBag<>();
		
		// Se crea una colecci�n de n�meros, del 1 al 10, para comprobar los filtros.
		ArrayList<Integer> num = new ArrayList<>();
		for(int i = 1; i <= 30; i++) num.add(i);
		
		// Se a�ade la colecci�n a ambas bolsas.
		bolsaConFiltro.addAll(num);
		bolsaSinFiltro.addAll(num);
		
		// Se comprueba que el filtro ha funcionado.
		imprimirBolsa(bolsaConFiltro);
		imprimirBolsa(bolsaSinFiltro);
		
		// Se comprueba que funciona correctamente.
		// Al a�adir un n�mero NO primo a ambas listas, solo se a�adir� a la bolsa con filtro.
		
		bolsaConFiltro.add(42);
		bolsaSinFiltro.add(42);
		
		imprimirBolsa(bolsaConFiltro);
		imprimirBolsa(bolsaSinFiltro);
		
		// Se comprueba la funcionalidad de el constructor copia.
		
		FilteredBag<Integer> bolsaCopia = new FilteredBag<>(bolsaConFiltro);
		
		// Se hacen m�s pruebas con la bolsa copia.
		
		imprimirBolsa(bolsaCopia);
		bolsaCopia.add(26); // no primo
		imprimirBolsa(bolsaCopia);
		bolsaCopia.add(43); // primo
		imprimirBolsa(bolsaCopia);
		
		// M�s test con constructores...
		FilteredBag<Integer> bolsaConFiltro2 = new FilteredBag<>(num, x -> esPrimo(x));
		FilteredBag<Integer> bolsaSinFiltro2 = new FilteredBag<>(num);
		
		imprimirBolsa(bolsaConFiltro2);
		imprimirBolsa(bolsaSinFiltro2);
		
		bolsaConFiltro2.add(88); // no deber�a a�adirse
		bolsaSinFiltro2.add(88); // deber�a a�adirse
		
		imprimirBolsa(bolsaConFiltro2);
		imprimirBolsa(bolsaSinFiltro2);
		
		bolsaConFiltro2.add(97); // deber�a a�adirse
		imprimirBolsa(bolsaConFiltro2);
	}
	
	
	public static boolean esPrimo(int x) {
		if(x == 1) return true;
		for(int i = 2; i <= x / 2; i++) if(x % i == 0) return false;
		return true;
	}
	

	private static void imprimirBolsa(FilteredBag<?> bag) {
		out.print("Contenido de la bolsa: ");
		for(Object i : bag) out.printf("%s ", i);
		out.printf("%n%n");
	}


}
