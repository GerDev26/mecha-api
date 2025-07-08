package com.mecha.api.service.interfaces;

import java.util.List;

public interface ICrudService<T> {
    public List<T> findAll();
    public T findById(Long id);
    public T save(T t);
    public T update(Long id, T t);
    public void deleteById(Long id);
}
