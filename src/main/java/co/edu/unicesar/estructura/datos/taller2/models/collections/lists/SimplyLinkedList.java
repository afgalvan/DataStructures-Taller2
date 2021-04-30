package co.edu.unicesar.estructura.datos.taller2.models.collections.lists;

import co.edu.unicesar.estructura.datos.taller2.models.collections.Contract;
import java.util.Comparator;
import lombok.Getter;
import lombok.val;

@Getter
public class SimplyLinkedList<T> extends LinkedList<T> {

    private SimplyNode<T> first;

    private SimplyNode<T> last;

    @Override
    public void add(T item) {
        val node = new SimplyNode<>(item);
        if (this.isEmpty()) {
            this.first = node;
        } else {
            this.last.next = node;
        }

        this.size++;
        this.last = node;
    }

    @Override
    public void pop() {
        if (this.isEmpty()) {
            return;
        }

        SimplyNode<T> toDelete = this.first;
        this.first = first.next;
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

        SimplyNode<T> penultimate = getNodeBefore(this.last);
        SimplyNode<T> toDelete = this.last;
        this.last = penultimate;
        this.last.next = null;
        toDelete.next = null;
        this.size--;
    }

    public SimplyNode<T> getNodeBefore(SimplyNode<T> node) {
        SimplyNode<T> cursor = this.first;

        while (cursor.next.next != null && cursor.next != node) {
            cursor = cursor.next;
        }

        return (cursor.next == node) ? cursor : null;
    }

    @Override
    protected void linkFirst(T item) {
        val simplyNode = new SimplyNode<>(item);
        simplyNode.next = this.first;
        this.first = simplyNode;
    }

    @Override
    protected void linkLast(T item) {
        val simplyNode = new SimplyNode<>(item);
        this.last.next = simplyNode;
        this.last = simplyNode;
    }

    @Override
    protected void linkAtMiddle(T item, Comparator<? super T> comparator) {
        val simplyNode = new SimplyNode<>(item);
        SimplyNode<T> cursor = this.first;

        while (
            cursor.next != null && comparator.compare(item, cursor.next.item) >= 0
        ) {
            cursor = cursor.next;
        }

        simplyNode.next = cursor.next;
        cursor.next = simplyNode;
    }

    @Contract(mutates = "this")
    private void deleteMiddleNode(SimplyNode<T> toDelete) {
        SimplyNode<T> cursor = getNodeBefore(toDelete);

        if (cursor.next == toDelete) {
            cursor.next = toDelete.next;
            toDelete.next = null;
            this.size--;
        }
    }

    @Contract(mutates = "this")
    public void remove(SimplyNode<T> node) {
        if (isEmpty()) {
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

    @Contract(mutates = "this")
    public void differenceUpdate(SimplyLinkedList<T> anotherList) {
        SimplyNode<T> cursorB = anotherList.first;

        while (cursorB != null) {
            SimplyNode<T> cursorA = this.first;
            while (cursorA != null) {
                SimplyNode<T> auxNext = cursorA.next;
                if (cursorA.item == cursorB.item) {
                    this.remove(cursorA);
                }
                cursorA = auxNext;
            }
            cursorB = cursorB.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder displayable = new StringBuilder();
        SimplyNode<T> cursor = this.first;

        while (cursor != null) {
            displayable.append(cursor).append(" -> ");
            cursor = cursor.next;
        }

        displayable.append("NULL");
        return displayable.toString();
    }

    @Getter
    public static class SimplyNode<E> extends Node<E> {

        SimplyNode<E> next;

        public SimplyNode(E item) {
            super(item);
        }

        public SimplyNode(Node<E> node) {
            super(node.item);
        }

        @Override
        public Node<E> next() {
            return next;
        }
    }
}