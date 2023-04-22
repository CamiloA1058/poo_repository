package org.rangotech.poointerfaces.repositorio;

import org.rangotech.poointerfaces.model.BaseEntity;
import org.rangotech.poointerfaces.repositorio.excepciones.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity> implements FullRepositorio<T>{

    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public void crear(T t) throws EscrituraDatosException{
        if (t == null){
            throw new EscrituraDatosException("Error al insertar un objeto en NULL");
        }
        if (dataSource.contains(t)){
            throw new EscrituraDatosException("Error el elemento con id: " +t.getId()+ ", ya existe en el Repositorio");
        }
        dataSource.add(t);
    }

    @Override
    public T buscarPorId(Integer id) throws LecturaDatosException {
        if (id == null || id <= 0){
            throw new LecturaDatosException("EL ID debe ser distinto de nulo o ser mayor a 0");
        }
        T t = null;
        for (T source: dataSource) {
            if (source.getId() != null && source.getId().equals(id)){
                t = source;
                break;
            }
        }
        if (t == null){
            throw new LecturaDatosException("No existe un registro con ese ID");
        }
        return t;
    }

    @Override
    public void eliminar(Integer id) throws LecturaDatosException{
        dataSource.remove(buscarPorId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return dataSource.size();
    }
}
