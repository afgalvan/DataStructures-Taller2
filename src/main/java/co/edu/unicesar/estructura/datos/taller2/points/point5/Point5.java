package co.edu.unicesar.estructura.datos.taller2.points.point5;

/*
 * Escriba  una  solución  al  problema  consistente  en RETIRAR de  una  ListaEnlazada
 * Simple cuya cabeza es cab1, todos aquellos elementos que se encuentren en OTRA lista
 * cuya cabeza es cab2. Considere que ambas listas contienen únicamente datos numéricos
 * enteros en cada nodo.
 */

import co.edu.unicesar.estructura.datos.taller2.models.collections.lists.SimplyLinkedList;
import java.util.Scanner;
import lombok.val;

public class Point5 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        val list1 = new SimplyLinkedList<Integer>();
        val list2 = new SimplyLinkedList<Integer>();

        System.out.println("LLENADO DE DATOS LISTA 1.\n");
        fillData(list1);
        System.out.println("\n-----------------------------");
        System.out.println("LLENADO DE DATOS LISTA 2.\n");
        fillData(list2);

        System.out.println("\n\nLista 1 Original.");
        System.out.println(list1);
        System.out.println("Lista 2.");
        System.out.println(list2);

        list1.differenceUpdate(list2);
        System.out.println("\nLista 1 retirando elementos iguales.");
        System.out.println(list1);
    }

    public static void fillData(SimplyLinkedList<Integer> simplyLinkedList) {
        char keepAsking = 's';

        while (keepAsking == 's') {
            System.out.print("Ingrese un número para el nodo: ");
            simplyLinkedList.add(scanner.nextInt());
            System.out.print("Desea agregar otro nodo? [S/N]: ");
            keepAsking = scanner.next().toLowerCase().charAt(0);
        }
    }
}
