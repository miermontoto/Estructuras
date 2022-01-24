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
    if(this.hasVertex(x)) return false;
    numVertex++;
    adjList.put(x, new TreeMap<>());
    return true;
  }

  public boolean removeVertex(Vertex x) {
    if(!this.hasVertex(x)) return false;
    numEdges -= degreeOut(x);
    adjList.remove(x);
    numVertex--;
    for(Map<Vertex, Double> val : adjList.values()) if(val.remove(x)) numEdges--;
    return true;
  }

  public boolean hasEdge(Vertex to, Vertex from) {
    if(!adjList.containsKey(from) || !adjList.containsKey(to)) return false;
    return adjList.get(from).containsKey(to);
  }

  public boolean addEdge(Vertex to, Vertex from, double weight) {
    if(hasEdge(to, from) || from.equals(to)) return false;
    if(addVertex(to)) numVertex++;
    if(addVertex(from)) numVertex++;
    adjList.get(from).put(to, weight));
    numEdges++;
    return true;
  }

  public boolean removeEdge(Vertex to, Vertex from) {
    if(!hasEdge(to, from)) return false;
    adjList.get(from).remove(to);
    numEdges--;
    return true;
  }

  public double weightEdge(Vertex to, Vertex from) {
    if(!hasEdge(to, from)) throw new NullPointerException();
    return adjList.get(from).get(to);
  }

  public int degreeIn(Vertex x) {
    if(!hasVertex(x)) throw new NullPointerException();
    int i = 0;
    for(Map<Vertex, Double> val : adjList.values())
      for(Vertex e : val.keySet()) if(e.equals(x)) i++;
    return i;
  }

  public int degreeOut(Vertex x) {
    if(!hasVertex(x)) throw new NullPointerException();
    return adjList.get(x).size();
  }

  public Collection<Vertex> adjacentsTo(Vertex x) {
    if(!hasVertex()) throw new NullPointerException();
    return adjList.get(x).keySet();
  }

  public Collection<Vertex> getAllVertex() {
    return adjList.keySet();
  }

}
