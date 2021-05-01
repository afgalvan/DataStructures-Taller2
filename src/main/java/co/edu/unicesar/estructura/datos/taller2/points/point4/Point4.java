package co.edu.unicesar.estructura.datos.taller2.points.point4;

/*
 * ESCRIBA UNA SOLUCIÓN AL PROBLEMA CONSISTENTE EN ACTUALIZAR UN CAMPO DE INFORMACIÓN DE
 * UNA LISTA ENLAZADA SIMPLE BASADO EN LOS DATOS DE OTRA LISTA IGUALMENTE ENLAZADA SIMPLE.
 * (a esta actividad se le denomina CRUZAR las listas).
 */

import co.edu.unicesar.estructura.datos.taller2.models.collections.lists.SimplyLinkedList;
import lombok.val;

public class Point4 {

    public static void main(String[] args) {
        val list1 = new SimplyLinkedList<Integer>();
        val list2 = new SimplyLinkedList<Integer>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list2.add(4);
        list2.add(2);
        list2.add(5);

        System.out.println(list1);
        list1.differenceUpdate(list2);
        System.out.println(list1);
    }
}
