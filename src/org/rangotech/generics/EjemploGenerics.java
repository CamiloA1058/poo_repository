package org.rangotech.generics;

import org.rangotech.poointerfaces.model.Cliente;
import org.rangotech.poointerfaces.model.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EjemploGenerics {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Camilo", "Arboleda"));

        Cliente cliente = clientes.iterator().next();

        Cliente[] clienteArreglo = {
                new Cliente("Camilo", "Arboleda"),
                new Cliente("Pinini", "Hoyos")
        };
        Integer[] enterosArreglo = {
                4,5,6,8,9
        };
        List<Cliente> clientesLista = fromArrayToList(clienteArreglo);
        List<Integer> enterosLista = fromArrayToList(enterosArreglo);

        List<Cliente> clientesListilla = fromArrayToList(new Cliente[]{
                new Cliente("Rango", "Hoyos"),
                new Cliente("Camilo", "Arboleda")
        }, new Integer[] {1,2,3,4});

        clientesListilla.forEach(System.out::println);

        List<ClientePremium> clientesPremium = fromArrayToList(new ClientePremium[]{
                new ClientePremium("Perguerselch", "Jijija")});

        System.out.println("====Lista clientes =====");
        imprimirLista(clientes);
        System.out.println("====Lista clientesLista====");
        imprimirLista(clientesLista);
        System.out.println("====Lista clientesPremium====");
        imprimirLista(clientesPremium);
        System.out.println("====Obtener Maximo====");
        System.out.println(maximo("10", "15", "9"));
    }
    //Bounded generics
    public static <T extends Number> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }
    public static <T extends Cliente & Comparator<T>> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }
    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }
    public static <T, G> List<T> fromArrayToList(T[] c, G[] g){
        for (G elemento:g) {
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }
    public static void imprimirLista(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }
    public static <T extends Comparable<T>> T maximo(T a, T b, T c){
        T max = a;
        max = b.compareTo(max) > 0 ? b : max;
        max = c.compareTo(max) > 0 ? c : max;
        return max;
    }
}
