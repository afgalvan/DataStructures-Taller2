package co.edu.unicesar.estructura.datos.taller2.points.collections.lists;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Node<T> {

    T item;

    @Override
    public String toString() {
        return "" +this.item;
    }
}
