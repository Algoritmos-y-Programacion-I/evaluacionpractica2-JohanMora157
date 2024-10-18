package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Controller control;
    private Scanner reader;

    public Executable() {

        control = new Controller();
        reader = new Scanner(System.in);

    }

    public static void main(String[] args) {

        Executable exe = new Executable();
        exe.control.preUpPillar();
        exe.menu();
    }

    /**
     * Descripcion: Despliega el menu principal de funcionalidades al usuario
     */
    public void menu() {

        boolean flag = true;

        do {

            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pillar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }

        } while (flag);

    }

    /**
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un
     * Project
     * en un Pillar en el sistema
     */
    public void registerProject() {
        reader.nextLine();
        System.out.println("Ingrese el tipo de Pilar 1=BIODIVERSIDA/2=AGUA/3=TRATAMIENTO DE BASURAS/4=ENERGIA: ");
        int typePillar = reader.nextInt();
        reader.nextLine();
        System.out.println("Ingrese el ID del Project: ");
        String id = reader.nextLine();

        System.out.println("Ingrese el nombre del Project: ");
        String name = reader.nextLine();

        System.out.println("Ingrese la descripcion del Project: ");
        String description = reader.nextLine();
        boolean status;
        System.out.println("Ingrese el estado del Project 1=true/2=false: ");
        int statusOption = reader.nextInt();
        if (statusOption == 1) {
            status = true;
        } else {
            status = false;
        }

        if (control.registerProjectInPillar(typePillar, id, name, description, status)) {
            System.err.println("Project registrado con exito al pilar: " + typePillar);
        } else {
            System.err.println("No se pudo registrar el Project");
        }

    }

    /**
     * Descripcion: Muestra al usuario los Projects registrados en un Pillar
     */
    public void showProjectsByPillar() {

        System.out.println("Ingrese el tipo de Pilar de los proyectos a consultar(1-4):");
        int typePillar = reader.nextInt();

        System.out.println(control.queryProjectsByPillar(typePillar));

    }

}
