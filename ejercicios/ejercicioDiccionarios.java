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
