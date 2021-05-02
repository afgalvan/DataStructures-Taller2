package co.edu.unicesar.estructura.datos.taller2.models.collections.lists;

import co.edu.unicesar.estructura.datos.taller2.models.collections.Contract;
import java.util.Comparator;
import java.util.function.Function;
import lombok.EqualsAndHashCode;
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
    protected void linkAtMiddle(T item, Function<T, Boolean> comparison) {
        val simplyNode = new SimplyNode<>(item);
        SimplyNode<T> cursor = this.first;

        while (cursor.next != null && comparison.apply(cursor.next.item)) {
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

    @Override
    public void remove(Node<T> node) {
        if (this.isEmpty()) {
            return;
        }

        SimplyNode<T> toDelete = node.toSimply();
        if (toDelete.equals(this.first)) {
            this.pop();
        } else if (toDelete.equals(last)) {
            this.detach();
        } else {
            this.deleteMiddleNode(toDelete);
        }
    }

    @Contract(mutates = "this")
    public void differenceUpdate(SimplyLinkedList<T> anotherList) {
        // prettier-ignore-start
        anotherList.forEach(
            foreignNode -> this.forEach(localNode -> {
                if (localNode.item == foreignNode.item) {
                    this.remove(localNode);
                }
            })
        );
        // prettier-ignore-end
    }

    @Override
    public String toString() {
        StringBuilder displayable = new StringBuilder();

        this.forEach(node -> displayable.append(node).append(" -> "));
        displayable.append("NULL");
        return displayable.toString();
    }

    @Getter
    @EqualsAndHashCode(callSuper = false)
    public static class SimplyNode<E> extends Node<E> {

        SimplyNode<E> next;

        public SimplyNode(E item) {
            super(item);
        }
    }
}
