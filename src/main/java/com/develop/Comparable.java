package com.develop;

/**
 * Interfaz Comparable para estructuras de datos
 * Debe ser implementada por cualquier clase que quiera ser ordenada
 */
public interface Comparable<T> {
    /**
     * Compara este objeto con otro objeto del mismo tipo
     * @param otro El objeto a comparar
     * @return Un valor negativo si este objeto es menor,
     *         cero si son iguales,
     *         un valor positivo si este objeto es mayor
     */
    int compareTo(T otro);
}