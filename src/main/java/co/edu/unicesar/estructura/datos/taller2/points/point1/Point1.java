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
import co.edu.unicesar.estructura.datos.taller2.models.collections.lists.LinkedList;
import co.edu.unicesar.estructura.datos.taller2.models.collections.lists.SimplyLinkedList;
import lombok.val;

import java.util.Collection;
import java.util.Scanner;

public class Point1 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        val doublyList = new DoublyLinkedList<Integer>();
        val simplyList = new SimplyLinkedList<Integer>();
        System.out.println("Llenar lista doblemente enlazada");
        repeatFunction(() -> listFill(doublyList));
        System.out.println("-----------------------------------");
        System.out.println("Llenar lista simplemente enlazada");
        repeatFunction(() -> listFill(simplyList));

        showResults(doublyList, simplyList);
    }

    public static void repeatFunction(Runnable registerMethod) {
        char keepAsking;
        do {
            registerMethod.run();

            System.out.print("Desea realizar otro registro? [S/N]: ");
            keepAsking = scanner.next().toLowerCase().charAt(0);
            scanner.nextLine();
        } while (keepAsking == 's');
    }

    public static void listFill(SimplyLinkedList<Integer> list) {
        System.out.print("Ingrese un número: ");
        list.add(scanner.nextInt());
    }

    public static void listFill(DoublyLinkedList<Integer> list) {
        System.out.print("Ingrese un número: ");
        Collections.addUniqueReverse(list, scanner.nextInt());
    }

    public static void copyUniques(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        list2.forEach(node2 -> {
            if (list1.contains(node2.getItem())) {
                list2.remove(node2);
            } else {
                Collections.addUniqueReverse(list1, node2.getItem());
            }
        });
    }

    public static void showResults(
        LinkedList<Integer> doublyList,
        LinkedList<Integer> simplyList
    ) {
        System.out.println("\nRESULTADO.");
        System.out.println("Lista doblemente enlazada original");
        System.out.println(doublyList);
        System.out.println("Lista simplemente enlazada original");
        System.out.println(simplyList);
        copyUniques(doublyList, simplyList);
        System.out.println("\n====================================\n");
        System.out.println("Lista doblemente enlazada modificada");
        System.out.println(doublyList);
        System.out.println("Lista simplemente enlazada modificada");
        System.out.println(simplyList);
    }
}
