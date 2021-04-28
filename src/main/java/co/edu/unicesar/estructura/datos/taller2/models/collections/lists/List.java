package co.edu.unicesar.estructura.datos.taller2.models.collections.lists;

import co.edu.unicesar.estructura.datos.taller2.models.collections.Contract;

import java.util.Comparator;

public interface List<T> {
    int size();

    boolean isEmpty();

    @Contract(mutates = "this")
    void add(T item);

    @Contract(mutates = "this")
    void remove(Node<T> item);

    boolean contains(T item);

    @Contract(mutates = "this")
    default void sort(Comparator<?> comparator) {
    }
}
