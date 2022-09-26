package com.mycompany.sistema;
import java.io.IOException;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String opc = null, opc1 = null;

        int id;
        String nombre;
        int edad;
        String genero;

        int dia = 0, mes = 0, anio = 0;
        Fecha f;

        double peso = 0, altura = 0;
        Mediciones m;

        int noPacientes = 0;
        Paciente p[] = new Paciente[50];

        System.out.println("\nBienvenido al sistema de registro médico\n");

        while (!"d".equals(opc)) {
            System.out.println("¿Qué desea hacer?:\n");
            System.out.println("  a)Agregar Paciente");
            System.out.println("  b)Buscar Paciente");
            System.out.println("  c)Mostrar Pacientes");
            System.out.println("  d)Salir");
            System.out.print("\n  Opción: ");
            opc = sc.nextLine();

            switch (opc) {
            case "a" -> {
                int i = 0;
                do {
                    System.out.print("\nIngresa el ID del paciente: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    for (int n = 0; n < noPacientes; n++) {
                        if (id == p[n].getId()) {
                            i = 1;
                            System.out.println("Ingrese otra ID");
                        }
                    }
                } while (i == 1);

                System.out.print("Ingresa el nombre del paciente: ");
                nombre = sc.nextLine();
                System.out.print("Ingresa el número de la edad del paciente: ");
                edad = sc.nextInt();
                System.out.print("Ingresa el género del paciente: ");
                sc.nextLine();
                genero = sc.nextLine();
                System.out.print("Ingresa las mediciones del paciente: \n");
                System.out.print(" Fecha: \n");
                System.out.print("     Dia: ");
                dia = sc.nextInt();
                System.out.print("     Mes: ");
                mes = sc.nextInt();
                System.out.print("     Año: ");
                anio = sc.nextInt();
                System.out.print(" Peso en kg: ");
                peso = sc.nextDouble();
                System.out.print(" Altura en m: ");
                altura = sc.nextDouble();
                sc.nextLine();
                System.out.print("\n");

                p[noPacientes] = new Paciente(id, nombre, edad, genero);
                noPacientes++;

            }

            case "b" -> {
                if (noPacientes > 0) {
                    System.out.print("\nIngrese el ID del paciente: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    int num = 0;
                    int j = 1;
                    for (int n = 0; n < noPacientes; n++) {
                        if (id == p[n].getId()) {
                            num = 1;
                            j = n;
                        }
                    }
                    if (num == 0) {
                        System.out.println("\nNo existe ese paciente");
                    } else {
                        f = new Fecha(dia, mes, anio);
                        m = new Mediciones(f, peso, altura);
                        p[j].agregar(m);
                        while (!"d".equals(opc1)) {
                            System.out.println("\n¿Qué desea hacer con el Paciente #" + id + "?:\n");
                            System.out.println("  a)Mostrar Datos");
                            System.out.println("  b)Agregar Datos");
                            System.out.println("  c)Imprimir historial de Mediciones");
                            System.out.println("  d)Regresar");
                            System.out.print("\n  Opción: ");
                            opc1 = sc.nextLine();

                            switch (opc1) {
                            case "a" -> {
                                System.out.println(p[j].toString());
                                System.out.print("\n");
                            }

                            case "b" -> {
                                System.out.print("Ingresa las nuevas mediciones del paciente: \n");
                                System.out.print(" Fecha: \n");
                                System.out.print("     Dia: ");
                                dia = sc.nextInt();
                                System.out.print("     Mes: ");
                                mes = sc.nextInt();
                                System.out.print("     Año: ");
                                anio = sc.nextInt();
                                System.out.print(" Peso en kg: ");
                                peso = sc.nextDouble();
                                System.out.print(" Altura en m: ");
                                altura = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("\n");

                                f = new Fecha(dia, mes, anio);
                                m = new Mediciones(f, peso, altura);
                                p[0].agregar(m);
                            }

                            case "c" -> {
                                if (p[j].getNoMediciones() > 0) {
                                    for (int n = 0; n < p[j].getNoMediciones(); n++) {
                                        System.out.print(p[j].getMediciones(n).toString() + "\n");
                                    }
                                } else {
                                    System.out.println(" ");
                                }
                            }

                            case "d" -> {
                                continue;
                            }

                            default -> {
                                System.out.println("\n\n    Elija una opción correcta\n");
                            }
                            }
                        }
                    }
                    System.out.print("\n");
                } else {
                    System.out.println("\nNo se ha registrado a nadie todavía\n");
                }
            }

            case "c" -> {
                if (noPacientes > 0) {
                    for (int n = 0; n < noPacientes; n++) {
                        System.out.println(p[n].toString());;
                    }
                } else {
                    System.out.println(" ");
                }
            }

            case "d" -> {
                System.out.print("\nGracias por usar el sistema de registro médico");
                System.out.print("\n");
                System.exit(0);
            }

            default -> {
                System.out.println("\n    Elija una opción correcta\n");
            }
            }
        }
    }
}