package co.edu.unicesar.estructura.datos.taller2.points.point2;

/*
 * SE TIENE UNA LISTA ENLAZADA DOBLE CUYO ÚNICO CAMPO DE INFORMACIÓN ES UN DATO DE TIPO
 * ENTERO CORTO. CONSTRUYA USTED UNA SOLUCIÓN ALGORÍTMICA QUE PERMÍTA RETIRAR DE DICHA
 * LISTA AQUELLOS NODOS QUE CONTENGAN NÚMEROS PARES, E INSERTAR DICHOS VALORES EN ORDEN
 * ASCENDENTE EN OTRA LISTA ENLAZADA DOBLE, SIN DUPLICADOS.
 */

import co.edu.unicesar.estructura.datos.taller2.models.collections.Collections;
import co.edu.unicesar.estructura.datos.taller2.models.collections.lists.DoublyLinkedList;
import java.util.Scanner;
import lombok.val;

public class Point2 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        val originalList = new DoublyLinkedList<Integer>();
        val evenList = new DoublyLinkedList<Integer>();

        System.out.println("LLENADO DE DATOS LISTA 1.\n");
        fillData(originalList);

        System.out.println("\n\n-----------------------------");
        System.out.println("Lista original.");
        System.out.println(originalList);

        System.out.println("-----------------------------");
        moveEvenNumbers(originalList, evenList);
        System.out.println("Lista original sin valores pares.");
        System.out.println(originalList);
        System.out.println("Lista con los valores pares.");
        System.out.println(evenList);
    }

    public static void fillData(DoublyLinkedList<Integer> list) {
        char keepAsking = 's';

        while (keepAsking == 's') {
            System.out.print("Ingrese un número para el nodo: ");
            list.add(scanner.nextInt());
            System.out.print("Desea agregar otro nodo? [S/N]: ");
            keepAsking = scanner.next().toLowerCase().charAt(0);
        }
    }

    public static void moveEvenNumbers(
        DoublyLinkedList<Integer> list,
        DoublyLinkedList<Integer> target
    ) {
        list.forEach(
            node -> {
                if (node.getItem() % 2 == 0) {
                    Collections.addUniqueSorting(target, node.getItem());
                    list.remove(node);
                }
            }
        );
    }
}
