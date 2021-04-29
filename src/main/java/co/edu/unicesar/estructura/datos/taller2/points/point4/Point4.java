package co.edu.unicesar.estructura.datos.taller2.points.point4;

import co.edu.unicesar.estructura.datos.taller2.models.collections.lists.SimplyLinkedList;
import lombok.val;

public class Point4 {

    public static void main(String[] args) {
        val list = new SimplyLinkedList<Integer>();
        list.add(5);
        list.add(2);
        list.add(3);
        System.out.println(list);
    }
}
