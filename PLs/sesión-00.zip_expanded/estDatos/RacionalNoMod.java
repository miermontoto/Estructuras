package estDatos;

public class RacionalNoMod extends AbstractRacional {
	
	Pair<Integer, Integer> par;
	
	public RacionalNoMod(int a, int b) {
		par = new PairImp<>(a, b);
	}
	
	public RacionalNoMod(Racional r) {
		par = new PairImp<>(r.numerador(), r.denominador());
	}

	@Override
	public int numerador() {return par.first();}

	@Override
	public int denominador() {return par.second();}
	
	

}
