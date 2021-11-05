/**
 * @author ALGORITMIA
 *
 */
public class DarLaVueltaALUMNO {

	/**
	 * @param args
	 */
	
	//Funcion rellenar el vector
	protected static void rellena(int[] vector, int talla){
		for(int i=0; i<talla; i++){
			vector[i]=i;
		}
	}
	
	
	//Funcion que dara la vuelta al vector
	protected static void dar_la_vuelta(int[] vector, int talla){
		int i,j,aux;
		for(i=0; i<talla-1;i++){
			for(j=0;j<talla-1-i;j++){
				aux=vector[j];
				vector[j]=vector[j+1];
				vector[j+1]=aux;
			}
		}
	}
	
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int REPETICIONES=100;
		int NUM_TALLAS=10;
		
		int i,j;
		double tiempo_inicial, tiempo_final;
		
		// Se declara un vector de tallas que son las que vamos a medir
		 int[] talla={1000,2000,3000,4000,5000,6000,7000,8000,9000,10000};
		 
		// Mostramos la cabecera de la tabla en la que figuraran tallas vs. tiempos
		 System.out.printf("DAR LA VUELTA A UN VECTOR\n\n");
		 System.out.printf("Tiempo empleado:\n\n");
		 System.out.printf("\t\tTalla\t\tTiempo\n\n");
		 System.out.printf("\t\t-----\t\t------\n\n");
		 
		 
		 // Bucle que recorre las diferentes tallas a medir
		 for (i=0;i<NUM_TALLAS;i++)
		     {
		     // Creamos un vector del tama�o correspondiente
			 int[] vector=new int [talla[i]];
		     		     
		     // Rellenado de un vector de talla[i]
		     rellena(vector,talla[i]);
		    
		     // Invocamos a la funcion clock antes de la franja de codigo a medir
		     tiempo_inicial=System.currentTimeMillis();
		     
		     // Bucle para repetir el experimento
		     for (j=0;j<REPETICIONES;j++)
		         // Invocacion de la funcion a medir
		         dar_la_vuelta(vector, talla[i]);
		     
		     // Invocamos a la funcion clock despues de la franja de codigo a medir
		     tiempo_final=System.currentTimeMillis();
		     
		     		     
		     // Mostramos la talla medida y el tiempo empleado (tiempo medido/repeticiones)
		     System.out.printf("\t\t%d\t\t%f\n", talla[i],((tiempo_final-tiempo_inicial) /1000 / REPETICIONES));  
		     } 
		 
		
	}

}
