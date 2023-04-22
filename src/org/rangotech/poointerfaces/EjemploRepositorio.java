package org.rangotech.poointerfaces;

import org.rangotech.poointerfaces.model.Cliente;
import org.rangotech.poointerfaces.repositorio.*;
import org.rangotech.poointerfaces.repositorio.excepciones.*;
import org.rangotech.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        try {
            FullRepositorio<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Camilo", "Arboleda"));
            repo.crear(new Cliente("Andres", "Arboleda"));
            repo.crear(new Cliente("Dovin", "Arboleda"));
            repo.crear(new Cliente("Enelia", "Hoyos"));

            Cliente cliente = new Cliente("Chispirito", "Hoyos");
            repo.crear(cliente);
            repo.crear(cliente);

            List<Cliente> clientes = repo.listar();
            clientes.forEach(System.out::println);

            System.out.println("===== Paginable ====");
            List<Cliente> paginable = repo.listar(0, 3);
            paginable.forEach(System.out::println);

            System.out.println("===== Ordenable =====");
            List<Cliente> ordenar = repo.listar("id", Direccion.DESC);
            ordenar.forEach(System.out::println);

            System.out.println("===== Editar =====");
            Cliente cEditado = new Cliente("Chinazo", "Arboleda");
            cEditado.setId(2);
            repo.editar(cEditado);
            Cliente c = repo.buscarPorId(2);
            //System.out.println(c);
            repo.listar("id", Direccion.DESC).forEach(System.out::println);

            System.out.println("===== Eliminar =====");
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);

            System.out.println("==== TOTAL ====");
            System.out.println("Total Registros: " + repo.total());
        } catch (LecturaDatosException e) {
            System.out.println("Lectura: " + e.getMessage());
        } catch (EscrituraDatosException e) {
            System.out.println("Escritura: " + e.getMessage());
        } catch (AccesoDatosException e) {
            System.out.println("Generica: " + e.getMessage());
        }
    }
}
