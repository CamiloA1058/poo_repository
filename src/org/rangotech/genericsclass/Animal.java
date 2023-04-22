package org.rangotech.genericsclass;

public class Animal {
    private TipoAnimal tipo;

    public Animal(TipoAnimal tipo) {
        this.tipo = tipo;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return tipo.toString();
    }
}
