package co.edu.unicesar.estructura.datos.taller2.points.collections.lists;

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
}
