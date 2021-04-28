package co.edu.unicesar.estructura.datos.taller2.points.collections.lists;

import lombok.var;

public class SimplyLinkedList<T> extends LinkedList<T> {

    private SimplyNode<T> first;
    private SimplyNode<T> last;

    private static class SimplyNode<E> extends Node<E> {

        SimplyNode<E> next;

        public SimplyNode(E item) {
            super(item);
        }
    }

    @Override
    public void add(T item) {
        SimplyNode<T> node = new SimplyNode<>(item);
        if (this.isEmpty()) {
            this.first = node;
        } else {
            this.last.next = node;
        }

        this.size++;
        this.last = node;
    }

    @Override
    public void remove(Node<T> item) {}

    @Override
    public String toString() {
        StringBuilder displayable = new StringBuilder();
        var cursor = this.first;

        while (cursor != null) {
            displayable.append(cursor).append(" -> ");
            cursor = cursor.next;
        }

        displayable.append("NULL");
        return displayable.toString();
    }
}
