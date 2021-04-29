package co.edu.unicesar.estructura.datos.taller2.points.point1;

import co.edu.unicesar.estructura.datos.taller2.models.collections.lists.SimplyLinkedList;
import lombok.val;

public class Point1 {

    public static void main(String[] args) {
        val list = new SimplyLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.addSorting(3, Integer::compareTo);

        val listString = new SimplyLinkedList<String>();
        listString.add("Javier");
        listString.add("Santiago");
        listString.addSorting("Maria", String::compareTo);
        listString.addSorting("Andres", String::compareTo);

        System.out.println(listString);
    }
}
