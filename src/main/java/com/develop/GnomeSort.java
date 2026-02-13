package com.develop;

/**
 * Implementación del algoritmo Gnome Sort
 * Complejidad temporal: O(n²) en el peor caso
 * Complejidad espacial: O(1)
 */
public class GnomeSort {

    /**
     * Ordena un arreglo usando Gnome Sort
     * @param arr Arreglo a ordenar que implementa Comparable
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        int index = 0;

        while (index < arr.length) {
            if (index == 0) {
                index++;
            } else if (arr[index].compareTo(arr[index - 1]) >= 0) {
                index++;
            } else {
                // Intercambiar
                T temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }

    /**
     * Ordena un arreglo de enteros usando Gnome Sort
     * @param arr Arreglo de enteros a ordenar
     */
    public static void sort(int[] arr) {
        int index = 0;

        while (index < arr.length) {
            if (index == 0) {
                index++;
            } else if (arr[index] >= arr[index - 1]) {
                index++;
            } else {
                // Intercambiar
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
}