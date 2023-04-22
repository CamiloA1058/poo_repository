package org.rangotech.genericsclass;

public class Automovil {
    private String marca;

    public Automovil(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("marca='").append(marca).append('\'');
        return sb.toString();
    }
}
