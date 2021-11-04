public class Fibonacci implements Iterable<Long> {
  private int n;

  public Fibonacci(int n) {
    if(n < 0) throw new IllegalArgumentException();
    this.n = n;
  }

  @Override
  public Iterator<Long> iterator() {
    return new FibonacciIterator();
  }

   class FibonacciIterator implements Iterator<Long> {
     private long current = 0;
     private long next = 1;
     private int index = 0;

     public boolean hasNext() {
       return index < n;
     }

     public Long next() {
       long ret = current;
       current = next;
       next += ret;
       return ret;
     }
   }
}
