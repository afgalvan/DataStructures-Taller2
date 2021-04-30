package co.edu.unicesar.estructura.datos.taller2.models.collections.lists;

import co.edu.unicesar.estructura.datos.taller2.models.collections.Contract;
import java.util.Comparator;

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
    protected abstract void linkAtMid(T item, Comparator<? super T> comparator);

    @Override
    public void addSorting(T item, Comparator<? super T> comparator) {
        if (this.isEmpty()) {
            add(item);
            return;
        }

        if (comparator.compare(item, this.getFirst().item) <= 0) {
            linkFirst(item);
        } else if (comparator.compare(item, this.getLast().item) >= 0) {
            linkLast(item);
        } else {
            linkAtMid(item, comparator);
        }
        this.size++;
    }
}
