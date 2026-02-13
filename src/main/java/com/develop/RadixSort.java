package com.develop;

/**
 * Implementación del algoritmo Radix Sort
 * Complejidad temporal: O(d * (n + k)) donde d es el número de dígitos
 * Complejidad espacial: O(n + k)
 * Nota: Este algoritmo solo funciona con números enteros no negativos
 */
public class RadixSort {

    /**
     * Ordena un arreglo de enteros no negativos usando Radix Sort
     * @param arr Arreglo de enteros a ordenar
     */
    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        // Encontrar el número máximo para determinar el número de dígitos
        int max = getMax(arr);

        // Hacer counting sort para cada dígito
        // exp es 10^i donde i es el dígito actual
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    /**
     * Encuentra el valor máximo en el arreglo
     */
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Counting sort basado en el dígito representado por exp
     */
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Inicializar count array
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        // Contar ocurrencias de cada dígito
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Cambiar count[i] para que contenga la posición actual de este dígito
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construir el arreglo de salida
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copiar el arreglo de salida al arreglo original
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    /**
     * Ordena un arreglo que puede contener números negativos
     * Separa positivos y negativos, ordena por separado y combina
     */
    public static void sortWithNegatives(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        // Contar números negativos y positivos
        int negCount = 0;
        for (int num : arr) {
            if (num < 0) negCount++;
        }

        if (negCount == 0) {
            // Solo positivos
            sort(arr);
            return;
        }

        if (negCount == arr.length) {
            // Solo negativos
            for (int i = 0; i < arr.length; i++) {
                arr[i] = -arr[i];
            }
            sort(arr);
            // Invertir orden y signos
            for (int i = 0; i < arr.length / 2; i++) {
                int temp = arr[i];
                arr[i] = -arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = -temp;
            }
            if (arr.length % 2 == 1) {
                arr[arr.length / 2] = -arr[arr.length / 2];
            }
            return;
        }

        // Mezcla de positivos y negativos
        int[] negatives = new int[negCount];
        int[] positives = new int[arr.length - negCount];

        int negIdx = 0, posIdx = 0;
        for (int num : arr) {
            if (num < 0) {
                negatives[negIdx++] = -num;
            } else {
                positives[posIdx++] = num;
            }
        }

        // Ordenar ambos arreglos
        sort(negatives);
        sort(positives);

        // Combinar: negativos en orden inverso, luego positivos
        int idx = 0;
        for (int i = negatives.length - 1; i >= 0; i--) {
            arr[idx++] = -negatives[i];
        }
        for (int i = 0; i < positives.length; i++) {
            arr[idx++] = positives[i];
        }
    }
}