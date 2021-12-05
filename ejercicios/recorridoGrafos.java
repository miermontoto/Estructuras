public <E> static void preordenGrafo(Grafo<E> g) {
  Map<E, boolean> marcados;
  for(int i = 0; g.data.length; i++) marcados.put(g.data[i], false);
  System.out.printf("Recorrido preorden: %s", g.data[0]);
  for(int i = 0; g.data.length; i++) if(!marcados.get(g.data[i])) recorrer(g.data[i], marcados, g);
}

private <E> static void recorrer(Nodo n, Map<E, boolean> marcados, Grafo<E> g) {
  marcados.put(n, true);
  for(Nodo a : g.acceso.get(n).keySet()) if(!marcados.get(a)) {
    marcados.put(a, true);
    System.out.printf("%s ", a);
    recorrer(a);
  }
}
