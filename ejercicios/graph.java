public class Graph<Vertex> {
  private int numVertex;
  private int numEdges;
  private Map<Vertex, Map<Vertex, Double>> adjList;

  public Graph() {
    adjList = new TreeMap<>();
    numVertex = 0;
    numEdges = 0;
  }

  public Graph(Graph<Vertex> g) {
    adjList = new TreeMap<>(g.adjList);
    numVertex = g.numVertex;
    numEdges = g.numEdges;
  }

  public boolean hasVertex(Vertex x) {
    return adjList.containsKey(x);
  }

  public boolean addVertex(Vertex x) {
    return this.hasVertex(x) ? false : adjList.put(x, null);
  }

  public boolean removeVertex(Vertex x) {
    for(Vertex e : adjList.keySet()) if(e.equals(x)) {adjList.remove(e); return true;}
    return false;
  }

  public boolean hasEdge(Vertex to, Vertex from) {
    if(!adjList.containsKey(from)) return false;
    Map<Vertex, Double> mtsi = adjList.get(to);
    if(mtsi == null) return false;
    return mtsi.containsKey(to);
  }

  public boolean addEdge(Vertex to, Vertex from, double weight) {
    if(hasEdge(to, from) ? false : adjList.get(from).put(to, weight)) {
      numEdges++;
      return true;
    }

    return false;
  }

  public boolean removeEdge(Vertex to, Vertex from) {
    if(!hasEdge(to, from)) return false;
    return adjList.get(from).remove(to);
  }

  public double weightEdge(Vertex to, Vertex from) {
    if(!hasEdge(to, from)) throw new NullPointerException();
    return adjList.get(from).get(to);
  }

  public int degreeIn(Vertex x) {
    int i = 0;
    if(!hasVertex(x)) return i;
    for(Map<Vertex, Double> val : adjList.values())
      if(val != null) for(Vertex e : val.keySet()) if(e.equals(x)) i++;
    return i;
  }

  public int degreeOut(Vertex x) {
    if(!hasVertex(x)) return 0;
    return adjList.get(x).size();
  }

  public Collection<Vertex> adjacentsTo(Vertex x) {
    ArrayList<Vertex> res = new ArrayList<>();
    if(!x.get(x).isNull()) for(Vertex e : adjList.get(x).keySet()) res.add(e);
    return res;
  }

  public Collection<Vertex> getAllVertex() {
    ArrayList<Vertex>
  }

}
