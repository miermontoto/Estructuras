// Se tiene un diccionario cuyas claves son el UO de cada alumno y
// su valor correspondiente la nota del curso.
// Generar una lista con los UO's de los alumnos que han sacado una nota dada.

public static List<String> listaAlumnosConNota(Map<String, Double> m, double f) {
  List<String> res = new ArrayList<>();
  for(Map.Entry<String, Double> par : m.entrySet()) {
    if(par.getValue().equals(f)) res.add(par.getKey());
  }
  return res;
}

// Modificar el algoritmo para que guarde en una lista los alumnos con una
// media dada.

public static List<String> listaAlumnosConMedia(Map<String, List<Double>> m, double f) {
  List<String> res = new ArrayList<>();
  for(Map.Entry<String, List<Double>> par : m.entrySet()) {
    if(media(par.getValue()).equals(f)) res.add(par.getKey());
  }
  return res;
}

public static double media(List<Double> l) {
  double res = 0.0;
  for(double d : l) res += l;
  return res / l.size();
}
