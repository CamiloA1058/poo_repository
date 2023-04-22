package org.rangotech.poointerfaces.model;

public class ClientePremium extends Cliente implements Comparable<Cliente>{
    private boolean vip;
    public ClientePremium(String nombre, String apellido) {
        super(nombre, apellido);
        boolean vip = true;
    }

    @Override
    public int compareTo(Cliente o) {
        return 0;
    }
}
