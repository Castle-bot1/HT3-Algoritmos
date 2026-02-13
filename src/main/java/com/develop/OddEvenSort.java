package com.develop;
/**
 * Implementación del algoritmo Odd-Even Sort (también conocido como Brick Sort)
 * Este es un algoritmo de ordenamiento que compara elementos en parejas
 * Complejidad temporal: O(n²) en el peor caso
 * Complejidad espacial: O(1)
 */
public class OddEvenSort {
    /**
     * Ordena un arreglo usando Odd-Even Sort
     * Compara elementos en posiciones pares/impares alternadamente
     * @param arr Arreglo a ordenar que implementa Comparable
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr.length <= 1) {
            return;
        }

        boolean sorted = false;

        while (!sorted) {
            sorted = true;

            // Fase impar: comparar elementos en índices impares con sus sucesores
            for (int i = 1; i < arr.length - 1; i += 2) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }

            // Fase par: comparar elementos en índices pares con sus sucesores
            for (int i = 0; i < arr.length - 1; i += 2) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    /**
     * Ordena un arreglo de enteros usando Odd-Even Sort
     * @param arr Arreglo de enteros a ordenar
     */
    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        boolean sorted = false;

        while (!sorted) {
            sorted = true;

            // Fase impar: comparar elementos en índices impares con sus sucesores
            for (int i = 1; i < arr.length - 1; i += 2) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }

            // Fase par: comparar elementos en índices pares con sus sucesores
            for (int i = 0; i < arr.length - 1; i += 2) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
