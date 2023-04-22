package org.rangotech.genericsclass;

public class EjemploGenericos {
    public static<T> void imprimirCamion(Camion<T> camion){
        for (T a:camion) {
            if (a instanceof Animal) {
                System.out.println(((Animal) a).getTipo());
            }
            if (a instanceof Maquinaria){
                System.out.println(((Maquinaria) a).getTipo());
            }
            if (a instanceof Automovil){
                System.out.println(((Automovil) a).getMarca());
            }
        }
    }
    public static void main(String[] args) {

        Camion<Animal> camionAnimales = new Camion<>(5);
        camionAnimales.addObjeto(new Animal(TipoAnimal.CABALLO));
        camionAnimales.addObjeto(new Animal(TipoAnimal.CABALLO));
        camionAnimales.addObjeto(new Animal(TipoAnimal.VACA));
        camionAnimales.addObjeto(new Animal(TipoAnimal.VACA));
        camionAnimales.addObjeto(new Animal(TipoAnimal.JIRAFA));

        imprimirCamion(camionAnimales);

        Camion<Maquinaria> camionMaquinaria = new Camion<>(5);
        camionMaquinaria.addObjeto(new Maquinaria("Bulldozer"));
        camionMaquinaria.addObjeto(new Maquinaria("Retroexcavador"));
        camionMaquinaria.addObjeto(new Maquinaria("Excavadora"));

        imprimirCamion(camionMaquinaria);

        Camion<Automovil> camionAutomovil = new Camion<>(5);
        camionAutomovil.addObjeto(new Automovil("Mustang"));
        camionAutomovil.addObjeto(new Automovil("Camaro"));
        camionAutomovil.addObjeto(new Automovil("BMW M4 Cabriolet"));
        camionAutomovil.addObjeto(new Automovil("Audi A4"));

        imprimirCamion(camionAutomovil);
    }
}
