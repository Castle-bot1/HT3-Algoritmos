package com.develop;
/**
 * Implementación del algoritmo Merge Sort
 * Complejidad temporal: O(n log n) en todos los casos
 * Complejidad espacial: O(n)
 */
public class MergeSort {

    /**
     * Ordena un arreglo usando Merge Sort
     * @param arr Arreglo a ordenar que implementa Comparable
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr.length <= 1) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Función recursiva de Merge Sort
     */
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void mergeSort(T[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /**
     * Combina dos subarreglos ordenados
     */
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Object[] leftArr = new Object[n1];
        Object[] rightArr = new Object[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (((T)leftArr[i]).compareTo((T)rightArr[j]) <= 0) {
                arr[k] = (T)leftArr[i];
                i++;
            } else {
                arr[k] = (T)rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = (T)leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = (T)rightArr[j];
            j++;
            k++;
        }
    }

    /**
     * Ordena un arreglo de enteros usando Merge Sort
     * @param arr Arreglo de enteros a ordenar
     */
    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        mergeSortInt(arr, 0, arr.length - 1);
    }

    private static void mergeSortInt(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSortInt(arr, left, mid);
            mergeSortInt(arr, mid + 1, right);
            mergeInt(arr, left, mid, right);
        }
    }

    private static void mergeInt(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
