package co.edu.unicesar.estructura.datos.taller2.models.collections.lists;

public abstract class Node<T> {

    T item;

    public Node(T item) {
        this.item = item;
    }

    public abstract Node<T> next();

    @Override
    public String toString() {
        return this.item.toString();
    }
}
