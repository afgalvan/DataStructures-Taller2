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

    @Contract(mutates = "this")
    private void linkFirst(SimplyNode<T> node) {
        node.next = this.first;
        this.first = node;
    }

    @Contract(mutates = "this")
    private void linkLast(SimplyNode<T> node) {
        this.last.next = node;
        this.last = node;
    }

    @Override
    public void addSorting(T item, Comparator<? super T> comparator) {
        val node = new SimplyNode<>(item);

        if (comparator.compare(item, this.first.item) <= 0) {
            linkFirst(node);
        } else if (comparator.compare(item, this.last.item) >= 0) {
            linkLast(node);
        } else {
            SimplyNode<T> cursor = this.first;
            while (
                cursor.next != null &&
                comparator.compare(item, cursor.next.item) >= 0
            ) {
                cursor = cursor.next;
            }

            node.next = cursor.next;
            cursor.next = node;
        }
        this.size++;
    }

    @Contract(mutates = "this")
    private void deleteMidNode(SimplyNode<T> toDelete) {
        SimplyNode<T> cursor = this.first.next;

        while (cursor.next != toDelete && cursor.next.next != null) {
            cursor = cursor.next;
        }

        if (cursor.next == toDelete) {
            cursor.next = toDelete.next;
            toDelete.next = null;
            this.size--;
        }
    }

    @Contract(mutates = "this")
    public void remove(SimplyNode<T> item) {
        if (isEmpty()) {
            return;
        }

        if (item == this.first) {
            this.pop();
        } else if (item == this.last) {
            this.detach();
        } else {
            this.deleteMidNode(item);
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

    public static class SimplyNode<E> extends Node<E> {

        SimplyNode<E> next;

        public SimplyNode(E item) {
            super(item);
        }

        @Override
        public Node<E> next() {
            return next;
        }
    }
}
