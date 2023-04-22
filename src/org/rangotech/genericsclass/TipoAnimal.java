package org.rangotech.genericsclass;

public enum TipoAnimal{
    CABALLO("Caballo"),
    VACA("Vaca"),
    JIRAFA("Vaca"),
    COCODRILO("Cocodrilo");

    private final String tipo;
    TipoAnimal(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tipo='").append(tipo).append('\'');
        return sb.toString();
    }
}
