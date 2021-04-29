package co.edu.unicesar.estructura.datos.taller2.points.point1;

import co.edu.unicesar.estructura.datos.taller2.models.collections.lists.SimplyLinkedList;
import lombok.val;

public class Point1 {

    public static void main(String[] args) {
        val list = new SimplyLinkedList<Integer>();
        addUnique(list, 5);
        addUnique(list, 2);
        addUnique(list, 3);
        addUnique(list, 5);
        addUnique(list, 9);
        addUnique(list, 2);

        System.out.println(list);
    }

    public static void addUnique(SimplyLinkedList<Integer> list, int data) {
        if (!list.contains(data)) {
            list.addSorting(data, Integer::compareTo);
        }
    }
}
