package app;

import estDatos.ClosedHash;

public class ClosedHashMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClosedHash<Integer> t=new ClosedHash<Integer>();
		t.add(7); t.add(15);t.add(34);
		t.add(4);t.add(19);t.add(7);t.add(7);t.add(7);
		System.out.println("t: "+t);
		System.out.println("EstÃ¡ el 4? "+t.contains(4));
		System.out.println("EstÃ¡ el 25? "+t.contains(25));
	    //pruebo el borrado de elementos
		t.remove(4); t.remove(19);
		System.out.println("t: "+t);
		System.out.println("******************************************************");
		//pruebo de la redimension 
		t.add(25);t.add(30);t.add(4);t.add(33);t.add(44);t.add(66);t.add(99);
		System.out.println("t: "+t);
        //prueba de insercion y redimension con cadenas de caracteres
		ClosedHash<String> ts=new ClosedHash<String>(7);
		ts.add("Pepe"); ts.add("Ppee");ts.add("Eva");ts.add("Lola");
		ts.add("Jaime");ts.add("Pedro");
		ts.add("Ana");
		ts.add("Juan");
		System.out.println("ts: "+ts);
		
		System.out.println("******************************************************");
		//prueba del constructor de copia
		ClosedHash<String> ts2=new ClosedHash<String>(ts);
		System.out.println("ts2: "+ts2);
		
		ts2.remove("Lola");
		ts2.add("Jorge");
		System.out.println("ts2: "+ts2);
		System.out.println("ts: "+ts);
		
		Integer [] a={10,25,33,40,54,69,70};
		TreeSet<Integer> s=new TreeSet<Integer>();
		s.addAll(Arrays.asList(a));
		ClosedHash<Integer> ti=new ClosedHash<Integer>(9);
		ti.addAll(s);
		System.out.println("ti: "+ti);		
		
		System.out.println("******************************************************");
		System.out.println(ts.printTable());	
		System.out.println(ts2.printTable());	
		System.out.println(ti.printTable());	
	}
	
}

//SALIDA completa
//t: [7, 15, 34, 4, 19]
//EstÃ¡ el 4? true
//EstÃ¡ el 25? false
//t: [7, 15, 34]
//******************************************************
//t: [7, 15, 34, 25, 30, 4, 33, 44, 66, 99]
//ts: [Pepe, Ppee, Eva, Lola, Jaime, Pedro, Ana, Juan]
//******************************************************
//ts2: [Pepe, Ppee, Eva, Lola, Jaime, Pedro, Ana, Juan]
//ts2: [Pepe, Ppee, Eva, Jaime, Pedro, Ana, Juan, Jorge]
//ts: [Pepe, Ppee, Eva, Lola, Jaime, Pedro, Ana, Juan]
//ti: [10, 25, 33, 40, 54, 69, 70]
//******************************************************
//0: 
//1: 
//2: Ana Lola 
//3: 
//4: Pepe Ppee 
//5: 
//6: Jaime 
//7: 
//8: Juan 
//9: 
//10: 
//11: Pedro 
//12: 
//13: 
//14: Eva 
//
//0: 
//1: Juan 
//2: 
//3: 
//4: Pepe Ppee 
//5: Ana Eva 
//6: 
//7: Jaime Pedro 
//8: 
//9: Jorge 
//10: 
//
//0: 54 
//1: 10 
//2: 
//3: 
//4: 40 
//5: 
//6: 33 69 
//7: 25 70 
