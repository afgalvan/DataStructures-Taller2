package co.edu.unicesar.estructura.datos.taller2.models.collections.lists;

import co.edu.unicesar.estructura.datos.taller2.models.collections.Contract;
import java.util.Comparator;

public interface List<T> {
    Node<T> getFirst();

    Node<T> getLast();

    int size();

    boolean isEmpty();

    @Contract(mutates = "this")
    void add(T item);

    @Contract(mutates = "this")
    void pop();

    @Contract(mutates = "this")
    void detach();

    @Contract(mutates = "this")
    void addSorting(T item, Comparator<? super T> comparator);

    default boolean contains(T item) {
        if (this.isEmpty()) {
            return false;
        }

        Node<T> cursor = this.getFirst();

        while (cursor.item != item && cursor.next() != null) {
            cursor = cursor.next();
        }

        return cursor.item == item;
    }

    default Node<T> getNodeOf(T item) {
        if (this.isEmpty()) {
            return null;
        }

        Node<T> cursor = this.getFirst();

        while (!cursor.item.equals(item) && cursor.next() != null) {
            cursor = cursor.next();
        }

        return (cursor.item.equals(item)) ? cursor : null;
    }
}