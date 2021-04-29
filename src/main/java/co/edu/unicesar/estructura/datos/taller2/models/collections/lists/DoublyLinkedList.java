package co.edu.unicesar.estructura.datos.taller2.models.collections.lists;

import java.util.Comparator;
import lombok.Getter;
import lombok.val;

@Getter
public class DoublyLinkedList<T> extends LinkedList<T> {

    private DoublyNode<T> first;
    private DoublyNode<T> last;

    @Override
    public void add(T item) {
        val node = new DoublyNode<>(item);
        if (this.isEmpty()) {
            this.first = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
        }

        this.size++;
        this.last = node;
    }

    @Override
    public void pop() {
        if (this.isEmpty()) {
            return;
        }

        DoublyNode<T> toDelete = this.first;
        this.first = first.next;
        if (this.first != null) {
            this.first.prev = null;
        }
        toDelete.next = null;
        this.size--;
    }

    @Override
    public void detach() {
        if (this.isEmpty()) {
            return;
        }
        if (this.first.equals(this.last)) {
            this.pop();
            return;
        }

        DoublyNode<T> toDelete = this.last;
        this.last = last.prev;
        this.last.next = null;
        toDelete.next = null;
        toDelete.prev = null;
        this.size--;
    }

    @Override
    public void addSorting(T item, Comparator<? super T> comparator) {}

    @Override
    public String toString() {
        StringBuilder displayable = new StringBuilder();
        DoublyNode<T> cursor = this.first;

        displayable.append("NULL");
        if (cursor != null) {
            displayable.append(" <- ");
        }

        while (cursor != null) {
            displayable.append(cursor);
            if (cursor.next != null) {
                displayable.append(" <-> ");
            } else {
                displayable.append(" -> NULL");
            }
            cursor = cursor.next;
        }

        return displayable.toString();
    }


    public static class DoublyNode<E> extends Node<E> {

        DoublyNode<E> next;
        DoublyNode<E> prev;

        public DoublyNode(E item) {
            super(item);
        }

        @Override
        public Node<E> next() {
            return next;
        }
    }
}
