package com.develop;

import java.io.*;
import java.util.Random;

/**
 * Generador de archivos con números aleatorios
 * Permite crear archivos con hasta 3000 números enteros
 */
public class FileGenerator {

    /**
     * Genera un archivo con números aleatorios
     * @param filename Nombre del archivo a crear
     * @param cantidad Cantidad de números a generar (máximo 3000)
     * @param min Valor mínimo de los números
     * @param max Valor máximo de los números
     */
    public static void generateRandomFile(String filename, int cantidad, int min, int max) {
        if (cantidad > 3000) {
            System.out.println("Advertencia: La cantidad excede 3000. Se ajustará a 3000.");
            cantidad = 3000;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            Random random = new Random();

            for (int i = 0; i < cantidad; i++) {
                int numero = random.nextInt(max - min + 1) + min;
                writer.println(numero);
            }

            System.out.println("Archivo '" + filename + "' generado exitosamente con " + cantidad + " números.");
        } catch (IOException e) {
            System.err.println("Error al generar el archivo: " + e.getMessage());
        }
    }

    /**
     * Genera un archivo con números aleatorios entre 0 y 9999
     * @param filename Nombre del archivo a crear
     * @param cantidad Cantidad de números a generar
     */
    public static void generateRandomFile(String filename, int cantidad) {
        generateRandomFile(filename, cantidad, 0, 9999);
    }

    /**
     * Lee números desde un archivo y los retorna en un arreglo
     * @param filename Nombre del archivo a leer
     * @return Arreglo de enteros con los números del archivo
     */
    public static int[] readNumbersFromFile(String filename) {
        try {
            // Primera pasada: contar cuántos números hay
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            int count = 0;
            while (reader.readLine() != null) {
                count++;
            }
            reader.close();

            // Segunda pasada: leer los números
            int[] numbers = new int[count];
            reader = new BufferedReader(new FileReader(filename));
            String line;
            int index = 0;

            while ((line = reader.readLine()) != null) {
                try {
                    numbers[index++] = Integer.parseInt(line.trim());
                } catch (NumberFormatException e) {
                    System.err.println("Advertencia: Línea inválida ignorada: " + line);
                }
            }
            reader.close();

            return numbers;

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return new int[0];
        }
    }

    /**
     * Guarda un arreglo de números en un archivo
     * @param filename Nombre del archivo
     * @param numbers Arreglo de números a guardar
     */
    public static void saveNumbersToFile(String filename, int[] numbers) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int num : numbers) {
                writer.println(num);
            }
            System.out.println("Números guardados en '" + filename + "'");
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}