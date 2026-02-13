package com.develop;

import java.util.Scanner;

/**
 * Programa principal para trabajar con algoritmos de ordenamiento
 * Incluye menú interactivo para generar archivos y ordenar con diferentes algoritmos
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static String archivoActual = "numeros.txt";

    public static void main(String[] args) {
        boolean continuar = true;

        System.out.println("--------------------------------------------------");
        System.out.println("  COMPARADOR DE ALGORITMOS DE ORDENAMIENTO     ");
        System.out.println("--------------------------------------------------");

        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    generarArchivo();
                    break;
                case 2:
                    ordenarConAlgoritmo();
                    break;
                case 3:
                    cambiarArchivo();
                    break;
                case 4:
                    System.out.println("\n¡Hasta luego!");
                    continuar = false;
                    break;
                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n------------------------------------------------");
        System.out.println("|                 MENU PRINCIPAL                 |");
        System.out.println("--------------------------------------------------");
        System.out.println("|  1. Generar archivo con números aleatorios     |");
        System.out.println("|  2. Ordenar con un algoritmo específico        |");
        System.out.println("|  3. Cambiar archivo de trabajo                 |");
        System.out.println("|  4. Salir                                      |");
        System.out.println("--------------------------------------------------");
        System.out.println("Archivo actual: " + archivoActual);
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void generarArchivo() {
        System.out.println("\n=== GENERAR ARCHIVO ===");
        System.out.print("Nombre del archivo (default: numeros.txt): ");
        String nombre = scanner.nextLine().trim();
        if (nombre.isEmpty()) {
            nombre = "numeros.txt";
        }

        System.out.print("Cantidad de números (máximo 3000): ");
        int cantidad = leerOpcion();
        if (cantidad <= 0 || cantidad > 3000) {
            System.out.println("Cantidad inválida. Usando 1000 por defecto.");
            cantidad = 1000;
        }

        FileGenerator.generateRandomFile(nombre, cantidad);
        archivoActual = nombre;
        System.out.println("\n✓ Archivo generado exitosamente.");
    }

    private static void ordenarConAlgoritmo() {
        System.out.println("\n=== ORDENAR CON ALGORITMO ===");
        System.out.println("1. Gnome Sort");
        System.out.println("2. Merge Sort");
        System.out.println("3. Quick Sort");
        System.out.println("4. Radix Sort");
        System.out.println("5. Odd-Even Sort (ordena por parejas)");
        System.out.print("Seleccione un algoritmo: ");

        int opcion = leerOpcion();
        if (opcion < 1 || opcion > 5) {
            System.out.println("Opción inválida.");
            return;
        }

        // Leer datos del archivo
        int[] numeros = FileGenerator.readNumbersFromFile(archivoActual);
        if (numeros.length == 0) {
            System.out.println("Error: No se pudieron leer los datos del archivo.");
            return;
        }

        System.out.println("\nDatos leídos: " + numeros.length + " números");
        System.out.print("¿Desea ver los primeros 10 números originales? (s/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("s")) {
            mostrarPrimeros(numeros, 10);
        }

        // Ordenar
        String nombreAlgoritmo = obtenerNombreAlgoritmo(opcion);
        System.out.println("\nOrdenando con " + nombreAlgoritmo + "...");

        ordenarConAlgoritmo(numeros, opcion);

        System.out.println("✓ Ordenamiento completado");

        if (estaOrdenado(numeros)) {
            System.out.println("✓ Verificación: Arreglo ordenado correctamente");
        } else {
            System.out.println("✗ ERROR: Arreglo no está ordenado correctamente");
        }

        System.out.print("\n¿Desea ver los primeros 10 números ordenados? (s/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("s")) {
            mostrarPrimeros(numeros, 10);
        }

        System.out.print("¿Desea guardar el resultado en un archivo? (s/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("s")) {
            System.out.print("Nombre del archivo de salida: ");
            String salida = scanner.nextLine().trim();
            if (!salida.isEmpty()) {
                FileGenerator.saveNumbersToFile(salida, numeros);
            }
        }
    }

    private static void cambiarArchivo() {
        System.out.println("\n=== CAMBIAR ARCHIVO ===");
        System.out.print("Ingrese el nombre del nuevo archivo: ");
        String nombre = scanner.nextLine().trim();

        if (!nombre.isEmpty()) {
            archivoActual = nombre;
            System.out.println("✓ Archivo cambiado a: " + archivoActual);
        }
    }

    private static void ordenarConAlgoritmo(int[] arr, int algoritmo) {
        switch (algoritmo) {
            case 1:
                GnomeSort.sort(arr);
                break;
            case 2:
                MergeSort.sort(arr);
                break;
            case 3:
                QuickSort.sort(arr);
                break;
            case 4:
                RadixSort.sortWithNegatives(arr);
                break;
            case 5:
                OddEvenSort.sort(arr);
                break;
        }
    }

    private static String obtenerNombreAlgoritmo(int opcion) {
        switch (opcion) {
            case 1: return "Gnome Sort";
            case 2: return "Merge Sort";
            case 3: return "Quick Sort";
            case 4: return "Radix Sort";
            case 5: return "Odd-Even Sort";
            default: return "Desconocido";
        }
    }

    private static boolean estaOrdenado(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void mostrarPrimeros(int[] arr, int n) {
        System.out.print("  ");
        for (int i = 0; i < Math.min(n, arr.length); i++) {
            System.out.print(arr[i]);
            if (i < Math.min(n, arr.length) - 1) {
                System.out.print(", ");
            }
        }
        if (arr.length > n) {
            System.out.print("...");
        }
        System.out.println();
    }
}