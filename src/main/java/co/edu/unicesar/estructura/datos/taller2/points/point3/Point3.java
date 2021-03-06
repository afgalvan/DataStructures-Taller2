package co.edu.unicesar.estructura.datos.taller2.points.point3;

/*
 * SE TIENE UNA LISTA ENLAZADA DOBLE CUYO ÚNICO CAMPO DE INFORMACIÓN ES UN DATO DE TIPO
 * String [40] (NOMBRE). ESCRIBA UNA SOLUCIÓN ALGORÍTMICA PARA BORRAR UN NOMBRE DE LA
 * LISTA, IMPLEMENTANDO ADEMÁS UNA "Papelera" de RECICLAJE que permita, a petición del
 * Usuario "Recuperar" un nombre BORRADO.
 */

import co.edu.unicesar.estructura.datos.taller2.models.collections.lists.DoublyLinkedList;
import java.util.Scanner;
import lombok.val;

public class Point3 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        val namesList = new DoublyLinkedList<String>();
        val recycleBin = new DoublyLinkedList<String>();

        System.out.println("Llenar lista de nombres.");
        registerName(namesList);

        System.out.println("\n-----------------------------");
        System.out.println("Lista de nombres");
        System.out.println(namesList);

        System.out.println("\n-----------------------------");
        System.out.println("\nBorrar nombre");
        moveName("borrar", namesList, recycleBin);
        System.out.println("\n\nLista de nombres");
        System.out.println(namesList);
        System.out.println("Papelera");
        System.out.println(recycleBin);

        System.out.println("\n-----------------------------");
        System.out.println("\nRecuperar nombre");
        moveName("recuperar", recycleBin, namesList);
        System.out.println("\n\nLista de nombres");
        System.out.println(namesList);
        System.out.println("Papelera");
        System.out.println(recycleBin);
    }

    public static void registerName(DoublyLinkedList<String> list) {
        char keepAsking = 's';

        while (keepAsking == 's') {
            System.out.print("Ingrese un nombre: ");
            list.add(scanner.nextLine());
            System.out.print("Desea agregar otro nombre? [S/N]: ");
            keepAsking = scanner.next().toLowerCase().charAt(0);
            scanner.nextLine();
        }
    }

    public static void moveName(
        String action,
        DoublyLinkedList<String> base,
        DoublyLinkedList<String> target
    ) {
        if (base.isEmpty()) {
            System.out.println("La lista origen está vacía.");
            return;
        }

        char keepAsking = 's';
        while (keepAsking == 's') {
            System.out.printf("Ingrese un nombre para %s: ", action);
            String name = scanner.nextLine();

            val toMove = (DoublyLinkedList.DoublyNode<String>) base.getNodeOf(name);

            if (toMove == null) {
                System.out.printf("Nombre %s no encontrado\n", name);
            } else {
                System.out.printf("Seguro que desea %s el nombre? [S/N]: ", action);
                char confirm = scanner.next().toLowerCase().charAt(0);
                scanner.nextLine();

                if (confirm == 's') {
                    target.add(toMove.getItem());
                    base.remove(toMove);
                    if (action.equals("borrar")) {
                        System.out.printf("%s enviado a la papelera\n", name);
                    } else {
                        System.out.printf("%s recuperado de la papelera\n", name);
                    }
                } else {
                    System.out.printf("Operación de %s cancelada\n", action);
                }
            }

            System.out.printf("Desea %s otro nombre? [S/N]: ", action);
            keepAsking = scanner.next().toLowerCase().charAt(0);
            scanner.nextLine();
        }
    }
}
