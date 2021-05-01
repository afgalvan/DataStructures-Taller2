package co.edu.unicesar.estructura.datos.taller2.points.point4;

/*
 * ESCRIBA UNA SOLUCIÓN AL PROBLEMA CONSISTENTE EN ACTUALIZAR UN CAMPO DE INFORMACIÓN DE
 * UNA LISTA ENLAZADA SIMPLE BASADO EN LOS DATOS DE OTRA LISTA IGUALMENTE ENLAZADA SIMPLE.
 * (a esta actividad se le denomina CRUZAR las listas).
 */

import co.edu.unicesar.estructura.datos.taller2.models.collections.lists.SimplyLinkedList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import lombok.val;
import lombok.var;

public class Point4 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        val personsList = new SimplyLinkedList<Person>();
        val gradesGroup = new SimplyLinkedList<GradeSet>();

        repeatRegistration(() -> registerPerson(personsList));
        System.out.println("\n--------------------------------");
        repeatRegistration(() -> registerGradeSet(gradesGroup));

        SimplyLinkedList<Student> studentsList = crossLists(
            personsList,
            gradesGroup
        );
        displayStudents(studentsList);
    }

    public static void registerPerson(SimplyLinkedList<Person> personsList) {
        Person person = new Person();
        AtomicBoolean repeated = new AtomicBoolean(false);

        System.out.println("\nREGISTRAR PERSONA");
        System.out.print("Ingrese el id: ");
        person.setId(scanner.nextLine());
        personsList.forEach(
            personNode -> {
                if (personNode.getItem().getId().equals(person.getId())) {
                    System.out.println("\nPersona ya registrada");
                    repeated.set(true);
                }
            }
        );

        if (!repeated.get()) {
            System.out.print("Ingrese el nombre: ");
            person.setName(scanner.nextLine());

            personsList.add(person);
        }
    }

    public static void registerGradeSet(SimplyLinkedList<GradeSet> gradesList) {
        GradeSet gradeSet = new GradeSet();
        System.out.println("\nREGISTRAR NOTAS");
        System.out.print("Ingrese el id: ");
        gradeSet.setId(scanner.nextLine());
        System.out.println("Notas de los cortes.");
        for (var i = 1; i <= 3; ++i) {
            System.out.printf("Corte %d: ", i);
            gradeSet.add(scanner.nextDouble());
        }

        gradesList.add(gradeSet);
    }

    public static void repeatRegistration(Runnable registerMethod) {
        char keepAsking;
        do {
            registerMethod.run();

            System.out.print("Desea realizar otro registro? [S/N]: ");
            keepAsking = scanner.next().toLowerCase().charAt(0);
            scanner.nextLine();
        } while (keepAsking == 's');
    }

    public static double computeProm(Student student) {
        var prom = 0.0;
        prom += student.getGradesList().get(0) * 0.3;
        prom += student.getGradesList().get(1) * 0.3;
        prom += student.getGradesList().get(2) * 0.4;
        return prom;
    }

    public static Student generateStudent(Person person, GradeSet grades) {
        val student = new Student();
        student.setId(person.getId());
        student.setName(person.getName());
        student.setGradesList(grades.getGradesList());
        student.setProm(computeProm(student));
        return student;
    }

    public static SimplyLinkedList<Student> crossLists(
        SimplyLinkedList<Person> personsList,
        SimplyLinkedList<GradeSet> groupGrades
    ) {
        val studentsList = new SimplyLinkedList<Student>();

        // prettier-ignore-start
        personsList.forEach(
            personNode -> groupGrades.forEach(gradeNode -> {
                if (personNode.getItem().getId().equals(gradeNode.getItem().getId())) {
                    studentsList.add(generateStudent(personNode.getItem(), gradeNode.getItem()));
                }
            })
        );
        // prettier-ignore-end
        return studentsList;
    }

    public static void displayStudents(SimplyLinkedList<Student> studentsList) {
        System.out.println("\n-----------------------------------");
        System.out.println("ESTUDIANTES");
        studentsList.forEach(
            node -> {
                Student student = node.getItem();
                System.out.println("-----------------------------------");
                System.out.printf("Id: %s\n", student.getId());
                System.out.printf("Nombre: %s\n", student.getName());
                System.out.printf("Notas: %s\n", student.getGradesList());
                System.out.printf("Promedio: %.1f\n", student.getProm());
            }
        );
    }
}
