package com.develop;
/**
 * Implementación del algoritmo Quick Sort
 * Complejidad temporal: O(n log n) promedio, O(n²) peor caso
 * Complejidad espacial: O(log n)
 */
public class QuickSort {

    /**
     * Ordena un arreglo usando Quick Sort
     * @param arr Arreglo a ordenar que implementa Comparable
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }
    
    /**
     * Función recursiva de Quick Sort
     */
    private static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Particiona el arreglo y retorna el índice del pivote
     */
    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                // Intercambiar arr[i] y arr[j]
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Intercambiar arr[i+1] y arr[high] (pivote)
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * Ordena un arreglo de enteros usando Quick Sort
     * @param arr Arreglo de enteros a ordenar
     */
    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        quickSortInt(arr, 0, arr.length - 1);
    }

    private static void quickSortInt(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionInt(arr, low, high);

            quickSortInt(arr, low, pi - 1);
            quickSortInt(arr, pi + 1, high);
        }
    }

    private static int partitionInt(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Intercambiar arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Intercambiar arr[i+1] y arr[high] (pivote)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}