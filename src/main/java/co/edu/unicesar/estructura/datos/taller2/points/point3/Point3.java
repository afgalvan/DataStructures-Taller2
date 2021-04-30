package co.edu.unicesar.estructura.datos.taller2.points.point3;

import co.edu.unicesar.estructura.datos.taller2.models.collections.lists.DoublyLinkedList;
import java.util.Scanner;
import lombok.val;

public class Point3 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        val namesList = new DoublyLinkedList<String>();
        val recycleBin = new DoublyLinkedList<String>();

        registerName(namesList);
        System.out.println("Lista de nombres");
        System.out.println(namesList);

        System.out.println("\nPapelera");
        moveName("borrar", namesList, recycleBin);
        System.out.println("\n\nLista de nombres");
        System.out.println(namesList);
        System.out.println("Papelera");
        System.out.println(recycleBin);
    }

    public static void registerName(DoublyLinkedList<String> list) {
        System.out.println("REGISTRAR NOMBRE");
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
                }
            }

            System.out.printf("Desea %s otro nombre? [S/N]: ", action);
            keepAsking = scanner.next().toLowerCase().charAt(0);
            scanner.nextLine();
        }
    }
}
