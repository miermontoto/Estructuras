public boolean add(E e) {
  if(elements + 1 == data.length) resize(2 * data.length + 1);
  else if (elements == 0) {data[0] = e; elements++;}
  else {
    int i = elements++;
    int padre = (pos - 1) / 2;
    while(pos > 0 && compare(e, data[padre]) < 0) {
      data[i] = data[padre];
      i = padre;
      padre = (pos - 1) / 2;
    }

    data[i] = e;
  }
  return true;
}
