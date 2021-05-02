package co.edu.unicesar.estructura.datos.taller2.points.point1;

/*
 * Se tiene una LISTA DOBLEMENTE ENLAZADA que almacena NUMEROS ENTEROS sin que ninguno
 * se repita, ordenados "Descendentemente" y, una LISTA ENLAZADA  SIMPLE  también
 * de  ENTEROS sin ningún orden en particular, como se ilustra en la Figura-1.
 * El proceso que se requiere es insertar los datos de la lista L2 en la lista L1, de tal
 * manera que la lista L1 siga estando sin valores duplicados y ordenada "Descendentemente".
 * Los nodos que contengan los valores de L2 que YA EXISTAN en  la  lista L1 y por lo tanto
 * NO PUDIERON SER INSERTADOS en L1 deben ser BORRADOS de L2.
 */

import co.edu.unicesar.estructura.datos.taller2.models.collections.Collections;
import co.edu.unicesar.estructura.datos.taller2.models.collections.lists.DoublyLinkedList;
import co.edu.unicesar.estructura.datos.taller2.models.collections.lists.SimplyLinkedList;
import lombok.val;

public class Point1 {

    public static void main(String[] args) {
        val doublyList = new DoublyLinkedList<Integer>();
        val simplyList = new SimplyLinkedList<Integer>();

        Collections.addUniqueReverse(simplyList, 3);
        Collections.addUniqueReverse(simplyList, 5);
        Collections.addUniqueReverse(simplyList, 2);
        Collections.addUniqueReverse(simplyList, 11);
        Collections.addUniqueReverse(simplyList, 8);
        Collections.addUniqueReverse(simplyList, 7);
        Collections.addUniqueReverse(simplyList, 45);
        Collections.addUniqueReverse(simplyList, 15);
        Collections.addUniqueReverse(simplyList, 2);
        Collections.addUniqueReverse(simplyList, 22);
        showResults(doublyList, simplyList);
    }



    public static <T> void showResults(DoublyLinkedList<T> doublyList, SimplyLinkedList<T> simplyList) {
        System.out.println(simplyList);
    }
}
