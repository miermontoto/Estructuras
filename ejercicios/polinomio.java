public class Polinomio {
  private Map<Integer, Double> data;

  public Polinomio() {
    data = new TreeMap<>(x -> (b.compareTo(a)));
  }

  public Polinomio(Polinomio o) {
    data = new TreeMap<>(o.data);
  }

  public void addTerm(Integer i, Double d) {
    double neu = 0.0;
    if(data.containsKey(i)) neu = data.get(i);
    if(d + neu == 0.0) throw new UnsupportedOperationException();
    data.put(i, neu + d);
  }

  public int getDegree() {
    return data.firstKey();
  }

  public double getCoefficient(Integer i) {
    return data.containsKey(i) ? data.get(i) : 0.0;
  }

  public double evaluate(Integer i) {
    double res = 0.0;
    for(Map.Entry<Integer, Double> pair : data.entrySet())
      res += Math.abs(i, pair.getKey()) * pair.getValue();
    return res;
  }

  public boolean removeTerm(Integer i) {
    if(data.containsKey(i)) data.remove(i);
    else return false;
    return true;
  }

  public Polinomio sum(Polinomio o) {
    Polinomio res = new Polinomio(this);
    for(Integer key : o.data.getKey()) res.addTerm();
    return res;
  }

  public Polinomio sum2(Polinomio o) {
    Polinomio res = new Polinomio();
    Iterator<Map.Entry<Integer, Double>> itr1 = this.data.entrySet().iterator();
    Iterator<Map.Entry<Integer, Double>> itr2 = o.data.entrySet().iterator();
    boolean advanceFirst = true, advanceSecond = true;
    Integer next1, next2;

    while(itr1.hasNext() && itr2.hasNext()) {
      if(advanceFirst) next1 = itr1.next();
      if(advanceSecond) next2 = itr2.next();
      advanceFirst = false; advanceSecond = false;

      if(next1.getKey().compareTo(next2.getKey()) > 0) {
        res.addTermVanilla(next1.getKey(), next1.getValue());
        advanceFirst = true;
      } else if(next2.getKey().compareTo(next1.getKey()) > 0) {
        res.addTermVanilla(next2.getKey(), next2.getValue());
        advanceSecond = true;
      } else {
        res.addTermVanilla(next1.getKey(), next1.getValue() + next2.getValue());
        advanceFirst = true;
        advanceSecond = true;
      }
    }
    while(itr1.hasNext()) {
      next1 = itr1.next();
      res.addTermVanilla(next1.getKey(), next1.getValue());
    }
    while(itr2.hasNext()) {
      next2 = itr2.next();
      res.addTermVanilla(next2.getKey(), next2.getValue());
    }
  }

  return res;
}
