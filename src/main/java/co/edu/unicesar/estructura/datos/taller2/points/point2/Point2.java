package co.edu.unicesar.estructura.datos.taller2.points.point2;

import co.edu.unicesar.estructura.datos.taller2.models.collections.lists.DoublyLinkedList;
import lombok.val;

public class Point2 {

    public static void main(String[] args) {
        val list = new DoublyLinkedList<Integer>();
        list.add(5);
        list.add(1);
        list.add(3);
        list.detach();
        list.addSorting(1, Integer::compareTo);
        System.out.println(list);
    }
}
