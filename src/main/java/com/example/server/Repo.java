package com.example.server;

public interface Repo<T, X> {
    void add(T t);
    void delete(X x);
    T search(X x);
    void update(T t);
}
