package co.edu.unicesar.estructura.datos.taller2.models.collections.lists;

import co.edu.unicesar.estructura.datos.taller2.models.collections.Contract;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class LinkedList<T> implements List<T> {

    protected int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Contract(mutates = "this")
    protected abstract void linkFirst(T item);

    @Contract(mutates = "this")
    protected abstract void linkLast(T item);

    @Contract(mutates = "this")
    protected abstract void linkAtMiddle(T item, Function<T, Boolean> function);

    @Override
    public void addSorting(T item, Comparator<? super T> comparator) {
        if (this.isEmpty()) {
            add(item);
            return;
        }

        Function<T, Boolean> biggerComparison = n ->
            comparator.compare(item, n) >= 0;

        if (comparator.compare(item, this.getFirst().item) <= 0) {
            linkFirst(item);
        } else if (biggerComparison.apply(this.getLast().getItem())) {
            linkLast(item);
        } else {
            linkAtMiddle(item, biggerComparison);
        }
        this.size++;
    }

    public void addReversing(T item, Comparator<? super T> comparator) {
        if (this.isEmpty()) {
            add(item);
            return;
        }

        Function<T, Boolean> lowerComparison = n -> comparator.compare(item, n) <= 0;

        if (comparator.compare(item, this.getFirst().item) >= 0) {
            linkFirst(item);
        } else if (lowerComparison.apply(this.getLast().item)) {
            linkLast(item);
        } else {
            linkAtMiddle(item, lowerComparison);
        }
        this.size++;
    }

    public void forEach(Consumer<Node<T>> consumer) {
        Node<T> cursor = this.getFirst();

        while (cursor != null) {
            Node<T> next = cursor.getNext();
            consumer.accept(cursor);
            cursor = next;
        }
    }

    @Contract(mutates = "this")
    public void map(Function<T, Boolean> function) {
        this.forEach(
                n -> {
                    if (function.apply(n.item)) {
                        this.remove(n);
                    }
                }
            );
    }
}
