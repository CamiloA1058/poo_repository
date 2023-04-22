package org.rangotech.poointerfaces;

import org.rangotech.poointerfaces.model.Producto;
import org.rangotech.poointerfaces.repositorio.*;
import org.rangotech.poointerfaces.repositorio.excepciones.*;
import org.rangotech.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProductos {
    public static void main(String[] args) {
        try {
            FullRepositorio<Producto> repo = new ProductoListRepositorio();
            repo.crear(new Producto("Mesa Gamer", 150));
            repo.crear(new Producto("Silla Gamer", 120));
            repo.crear(new Producto("Tarjeta Grafica", 500));
            repo.crear(new Producto("Procesador AMD", 280));

            List<Producto> productos = repo.listar();
            productos.forEach(System.out::println);

            System.out.println("===== Paginable ====");
            List<Producto> paginable = repo.listar(0, 3);
            paginable.forEach(System.out::println);

            System.out.println("===== Ordenable =====");
            List<Producto> ordenar = repo.listar("id", Direccion.DESC);
            ordenar.forEach(System.out::println);

            System.out.println("===== Editar =====");
            Producto pEditado = new Producto("Tarjeta Grafica", 420);
            pEditado.setId(3);
            repo.editar(pEditado);
            Producto p = repo.buscarPorId(2);
            //System.out.println(c);
            repo.listar("precio", Direccion.DESC).forEach(System.out::println);

            System.out.println("===== Eliminar =====");
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);

            System.out.println("==== TOTAL ====");
            System.out.println("Total Registros: " + repo.total());
        } catch (
                LecturaDatosException e) {
            System.out.println(e.getMessage());
        } catch (
                EscrituraDatosException e) {
            System.out.println(e.getMessage());
        } catch (
                AccesoDatosException e) {
            System.out.println(e.getMessage());
        }
    }
}
