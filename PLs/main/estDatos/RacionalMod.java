package estDatos;

public class RacionalMod extends RacionalNoMod {

	public RacionalMod(int a, int b) {
		super(a, b);
	}
	
	public RacionalMod(Racional r) {
		super(r.numerador(), r.denominador());
	}
	
	@Override
	public void setNumerador(int i) {this.par.setFirst(i);}
	
	@Override
	public void setDenominador(int i) {this.par.setSecond(i);}
	
	public void reduce() {
		int mcd = Racional.mcd(this.numerador(), this.denominador());
		this.setNumerador(numerador() / mcd);
		this.setDenominador(denominador() / mcd);
	}
	
}
