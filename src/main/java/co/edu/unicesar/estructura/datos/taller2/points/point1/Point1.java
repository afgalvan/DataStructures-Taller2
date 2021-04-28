package co.edu.unicesar.estructura.datos.taller2.points.point1;

import co.edu.unicesar.estructura.datos.taller2.models.collections.lists.SimplyLinkedList;
import java.util.LinkedList;

public class Point1 {

    public static void main(String[] args) {
        LinkedList<String> l;
        SimplyLinkedList<Integer> list = new SimplyLinkedList<>();
        list.add(5);
        list.add(2);
        list.add(3);
        System.out.println(list);
    }
}
