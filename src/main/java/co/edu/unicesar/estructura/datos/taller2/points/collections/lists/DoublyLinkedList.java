package co.edu.unicesar.estructura.datos.taller2.points.collections.lists;

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
}
