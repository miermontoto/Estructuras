package estDatos;

public abstract class AbstractRacional implements Racional {
	
	@Override
	public String toString() {
		return denominador() == 1 ?
				String.format("%d", numerador()) : 
					String.format("%d/%d", numerador(), denominador());
	}
	
	@Override
	public boolean equals(Object o) {
		boolean check = false;
		if(o instanceof Racional) if(((Racional) o).compareTo(this) == 0) check = true;
		return check;
	}
}
