package co.edu.unicesar.estructura.datos.taller2.points.point6;

/*
 * Se tienen 2 listas enlazadas simples cuyas cabezas son: cab1 y cab2 respectivamente.
 * Escriba una solución al problema consistente en AGREGAR o RETIRAR de la lista cab1,
 * todos aquellos nodos que en la lista cab2 tengan en el campo Accion un carácter
 * "A" o "R", respectivamente.
 */

import co.edu.unicesar.estructura.datos.taller2.models.collections.lists.SimplyLinkedList;
import java.util.Scanner;
import lombok.val;

public class Point6 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        val list1 = new SimplyLinkedList<Integer>();
        val list2 = new SimplyLinkedList<ActionItem>();

        System.out.println("LLENADO DE DATOS LISTA 1.\n");
        fillData(() -> askData1(list1));
        System.out.println("\n-----------------------------");
        System.out.println("LLENADO DE DATOS LISTA 2.\n");
        fillData(() -> askData2(list2));

        System.out.println("\n\n\nLista 1 Original");
        System.out.println(list1);
        System.out.println("Lista 2");
        System.out.println(list2);

        runAction(list1, list2);
        System.out.println("\nResultado");
        System.out.println("Lista 1");
        System.out.println(list1);
        System.out.println("Lista 2");
        System.out.println(list2);
    }

    public static void askData1(SimplyLinkedList<Integer> simplyLinkedList) {
        System.out.print("Ingrese un número: ");
        simplyLinkedList.add(scanner.nextInt());
    }

    public static void askData2(SimplyLinkedList<ActionItem> simplyLinkedList) {
        val actionItem = new ActionItem();
        System.out.print("Ingrese un número: ");
        actionItem.setCode(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Ingrese una acción [A/R]: ");
        actionItem.setAction(scanner.next().toUpperCase().charAt(0));
        simplyLinkedList.add(actionItem);
    }

    public static void fillData(Runnable askingMethod) {
        char keepAsking = 's';

        while (keepAsking == 's') {
            askingMethod.run();
            System.out.print("\nDesea agregar otro nodo? [S/N]: ");
            keepAsking = scanner.next().toLowerCase().charAt(0);
        }
    }

    public static void runAction(
        SimplyLinkedList<Integer> list1,
        SimplyLinkedList<ActionItem> list2
    ) {
        list2.forEach(
            node -> {
                if (node.getItem().getAction() == 'A') {
                    list1.add(node.getItem().getCode());
                } else if (node.getItem().getAction() == 'R') {
                    deleteAllOccurrences(list1, node.getItem().getCode());
                }
            }
        );
    }

    public static void deleteAllOccurrences(
        SimplyLinkedList<Integer> list1,
        int code
    ) {
        SimplyLinkedList.SimplyNode<Integer> toDelete;
        do {
            toDelete = (SimplyLinkedList.SimplyNode<Integer>) list1.getNodeOf(code);
            if (toDelete != null) {
                list1.remove(toDelete);
            }
        } while (toDelete != null);
    }
}
