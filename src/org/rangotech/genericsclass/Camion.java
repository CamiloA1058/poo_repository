package org.rangotech.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion<T> implements Iterable<T>{
    private List<T> objetos;
    private int max;

    public Camion(int max) {
        this.max = max;
        this.objetos = new ArrayList();
    }
    public void addObjeto(T objeto){
        if (objetos.size() <= max){
            objetos.add(objeto);
        }  else {
            throw new RuntimeException("no hay mas espacio");
        }
    }
    @Override
    public Iterator<T> iterator() {
        return objetos.iterator();
    }
}
