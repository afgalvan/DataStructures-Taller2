package co.edu.unicesar.estructura.datos.taller2.models.collections.lists;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Node<T> {

    T item;

    public abstract Node<T> next();

    @Override
    public String toString() {
        return this.item.toString();
    }
}
