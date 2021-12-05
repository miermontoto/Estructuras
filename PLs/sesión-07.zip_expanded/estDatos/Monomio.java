package estDatos;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Tipo de dato no modificable Monomio. Un monomio consta de dos partes:
 * <ul><li>Un número real denominado coeficiente</li>
 * <li>Un literal constituido por productos de variables con un
 * exponente natural</li></ul>
 */
public class Monomio {
	private Map<Character, Integer> data;
	private double coeficiente;

	/**
	 * Crea el monomio de coeficiente 1 y literal vacío.
	 */
	public Monomio() {
		coeficiente = 1.0; // elemento neutro de la operación
		data = new TreeMap<>();
	}
	
	public double getCoeficiente() {
		return this.coeficiente;
	}

	/**
	 * Crea el monomio que se proporciona mediante la cadena de
	 * caracteres especificada.
	 * @param str la cadena dada
	 * @throws IllegalArgumentException si la cadena de caracteres no casa
	 * con el patrón {@code ((?:\+|-)?\d*(?:\.\d*)?)?(\p{Alpha}\^?\d*)*}
	 */
	public Monomio (String str) {
		// se proporciona la parte de validación mediante
		// la expresión regular de patrón indicado
		this();
		String patternCoef = "((?:\\+|-)?\\d*(?:\\.\\d*)?)?";
		String patternLiteral = "(\\p{Alpha}\\^?\\d*)*";
		if (str.isEmpty() ||
				!str.matches(patternCoef + patternLiteral)) {
			throw new IllegalArgumentException("Monomio mal formado");
		}

		Pattern pattern = Pattern.compile(patternCoef);
		Matcher matcher = pattern.matcher(
				str.subSequence(0, str.length()));

		int startLiteral = 0;
		if (matcher.find() && !matcher.group().isEmpty()) {
			// obtener el coeficiente
			this.coeficiente = Double.parseDouble(matcher.group());
			startLiteral = matcher.end();
		}

		// string del literal del monomio
		String literal = str.substring(startLiteral);

        pattern = Pattern.compile("\\p{Alpha}\\^?\\d*");
        matcher = pattern.matcher(literal);
        while (matcher.find()) { // obtener una variable y su exponente
        	String s = matcher.group();
        	// variable (un carácter)
        	char variable = s.charAt(0);
        	// exponente de la variable
        	int exponente =
        			s.length() == 1 ? 1 : Integer.parseInt(s.substring(2));
        	
        	int neu = 0; // elemento neutro de la operación
			if(data.containsKey(variable)) neu = data.get(variable);
			data.put(variable, exponente + neu);

        }
	}
	
	public Monomio(Monomio m) {
		//this(String.format("%f%s", m.getCoeficiente(), m.toString()));
		this.coeficiente = m.coeficiente;
		this.data = m.data;
	}

	public int grado() {
		int res = 0; // elemento neutro de la operación
		for(int i : data.values()) res += i;
		return res;
	}
	
	public static Monomio porEscalar(double f, Monomio m) {
		return new Monomio(String.format("%f%s", f * m.getCoeficiente(), m.getLiteral()));
	}
	
	
	public String getLiteral() {
		String s = "";
		for(Map.Entry<Character, Integer> map : data.entrySet()) {
			s += String.format("%c^%d", map.getKey(), map.getValue());
		}
		return s;
	}
	
	@Override
	public String toString() {
		String s = String.format("%f", this.getCoeficiente());
		s += this.getLiteral();
		return s;
	}
	
	public static Monomio suma(Monomio m1, Monomio m2) {
		if(!m1.semejante(m2)) throw new UnsupportedOperationException();
		return new Monomio(String.format("%f%s", m1.getCoeficiente() + m2.getCoeficiente(), m1.getLiteral()));
	}
	
	public static Monomio sumaAlternativa(Monomio m1, Monomio m2) {
		if(!m1.semejanteAlternativo(m2)) throw new UnsupportedOperationException();
		Monomio r = new Monomio();
		r.coeficiente = m1.coeficiente + m2.coeficiente;
		r.data = new TreeMap<>(m1.data);
		return r;
	}
	
	public boolean semejanteAlternativo(Monomio b) {
		return this.data.equals(b.data);
	}
	
	public boolean semejante(Monomio b) {
		return this.getLiteral().equals(b.getLiteral());
	}
	
	public static Monomio potencia(Monomio m, int x) {
		String s = String.format("%f", Math.pow(m.getCoeficiente(), x));
		for(Map.Entry<Character, Integer> map : m.data.entrySet()) s += String.format("%c^%d", map.getKey(), map.getValue() * x);
		return new Monomio(s);
	}
	
	public static Monomio potenciaAlternativa(Monomio m, int x) {
		Monomio r = new Monomio();
		r.data = new TreeMap<>(m.data);
		r.coeficiente = Math.pow(m.coeficiente, x);
		for(Map.Entry<Character, Integer> pair : r.data.entrySet()) r.data.put(pair.getKey(), pair.getValue() * x);
		return r;
	}
	
	public static Monomio producto(Monomio m1, Monomio m2) {
		return new Monomio(String.format("%f%s%s", m1.getCoeficiente() * m2.getCoeficiente(), m1.getLiteral(), m2.getLiteral()));
	}
	
	public static Monomio productoAlternativo(Monomio m1, Monomio m2) {
		Monomio r = new Monomio();
		r.coeficiente = m1.coeficiente * m2.coeficiente;
		r.data = new TreeMap<>(m1.data);
		for(Map.Entry<Character, Integer> pair : m2.data.entrySet()) {
			Character k = pair.getKey();
			Integer v = pair.getValue();
			if(r.data.containsKey(k)) r.data.put(k, r.data.getValue(k) + v);
			else r.data.put(k, v);
		}
		return r;
	}

}
