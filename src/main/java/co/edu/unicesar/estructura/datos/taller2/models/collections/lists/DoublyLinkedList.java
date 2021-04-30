package co.edu.unicesar.estructura.datos.taller2.models.collections.lists;

import co.edu.unicesar.estructura.datos.taller2.models.collections.Contract;
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

    @Contract(mutates = "this")
    private void deleteMiddleNode(DoublyNode<T> toDelete) {
        DoublyNode<T> cursor = toDelete.getPrev();

        if (cursor.next == toDelete) {
            cursor.next = toDelete.next;
            toDelete.next = null;
            this.size--;
        }
    }

    @Contract(mutates = "this")
    public void remove(DoublyNode<T> node) {
        if (this.isEmpty()) {
            return;
        }

        if (node == this.first) {
            this.pop();
        } else if (node == this.last) {
            this.detach();
        } else {
            this.deleteMiddleNode(node);
        }
    }

    @Override
    protected void linkFirst(T item) {
        DoublyNode<T> doublyNode = new DoublyNode<>(item);
        doublyNode.next = this.first;
        this.first.prev = doublyNode;
        this.first = doublyNode;
    }

    @Override
    protected void linkLast(T item) {
        DoublyNode<T> doublyNode = new DoublyNode<>(item);
        doublyNode.prev = this.last;
        this.last.next = doublyNode;
        this.last = doublyNode;
    }

    @Override
    protected void linkAtMiddle(T item, Comparator<? super T> comparator) {
        DoublyNode<T> cursor = this.first;
        DoublyNode<T> doublyNode = new DoublyNode<>(item);
        while (cursor.next != null && comparator.compare(item, cursor.item) >= 0) {
            cursor = cursor.next;
        }

        doublyNode.next = cursor.next;
        cursor.next = doublyNode;
    }

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

    @Getter
    public static class DoublyNode<E> extends Node<E> {

        DoublyNode<E> next;
        DoublyNode<E> prev;

        public DoublyNode(E item) {
            super(item);
        }

        public DoublyNode(Node<E> node) {
            super(node.item);
        }

        @Override
        public Node<E> next() {
            return next;
        }
    }
}
