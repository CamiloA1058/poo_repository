package org.rangotech.poointerfaces.repositorio;

import org.rangotech.poointerfaces.repositorio.excepciones.*;

import java.util.List;

public interface Repositorio<T> {
    List<T> listar();
    T buscarPorId(Integer id) throws AccesoDatosException;
    void crear(T t) throws AccesoDatosException;
    void editar(T t) throws AccesoDatosException;
    void eliminar(Integer id) throws AccesoDatosException;
}
