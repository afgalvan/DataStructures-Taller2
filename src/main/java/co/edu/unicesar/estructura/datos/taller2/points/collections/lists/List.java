package co.edu.unicesar.estructura.datos.taller2.points.collections.lists;

public interface List<T> {
    int size();

    boolean isEmpty();

    void add(T item);

    void remove(Node<T> item);
}
