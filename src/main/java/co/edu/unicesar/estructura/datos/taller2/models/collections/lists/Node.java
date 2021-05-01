package co.edu.unicesar.estructura.datos.taller2.models.collections.lists;

import lombok.Getter;

@Getter
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

    public DoublyLinkedList.DoublyNode<T> toDoubly() {
        return (DoublyLinkedList.DoublyNode<T>) this;
    }

    public SimplyLinkedList.SimplyNode<T> toSimply() {
        return (SimplyLinkedList.SimplyNode<T>) this;
    }
}
