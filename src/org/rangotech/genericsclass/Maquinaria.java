package org.rangotech.genericsclass;

public class Maquinaria {
    private String tipo;

    public Maquinaria(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Tipo='").append(tipo).append('\'');
        return sb.toString();
    }
}
