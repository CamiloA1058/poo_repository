package org.rangotech.poointerfaces.repositorio;

public interface FullRepositorio<T> extends
        Repositorio<T>,
        PaginableRepositorio<T>,
        OrdenableRepositorio<T>,
        ContableRepositorio {
}
