package co.edu.unicesar.estructura.datos.taller2.models.collections;

import co.edu.unicesar.estructura.datos.taller2.models.collections.lists.LinkedList;
import java.util.Collection;
import java.util.Comparator;

public final class Collections {

    private Collections() {}

    public static <T> void addUnique(LinkedList<T> list, T data) {
        if (!list.contains(data)) {
            list.add(data);
        }
    }

    public static <T> void addUniqueSorting(
        LinkedList<T> list,
        T data,
        Comparator<T> comparator
    ) {
        if (!list.contains(data)) {
            list.addSorting(data, comparator);
        }
    }

    public static void addUniqueSorting(LinkedList<Integer> list, int data) {
        Collections.addUniqueSorting(list, data, Integer::compareTo);
    }

    public static void addUniqueSorting(LinkedList<String> list, String data) {
        Collections.addUniqueSorting(list, data, String::compareTo);
    }
}
