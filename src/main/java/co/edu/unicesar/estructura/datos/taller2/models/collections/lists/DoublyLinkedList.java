package co.edu.unicesar.estructura.datos.taller2.models.collections.lists;

import java.util.Comparator;

public class DoublyLinkedList<T> extends LinkedList<T> {

    private DoublyNode<T> first;
    private DoublyNode<T> last;

    private static class DoublyNode<E> extends Node<E> {

        DoublyNode<E> next;
        DoublyNode<E> prev;

        public DoublyNode(E item) {
            super(item);
        }
    }

    @Override
    public void add(T item) {}

    @Override
    public void remove(Node<T> item) {}

    @Override
    public boolean contains(T item) {
        return false;
    }

    @Override
    public void sort(Comparator<?> comparator) {
        super.sort(comparator);
    }
}
