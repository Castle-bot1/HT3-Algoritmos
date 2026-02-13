# Comparador de Algoritmos de Ordenamiento

Este proyecto implementa diferentes algoritmos de ordenamiento en Java.

## Algoritmos Implementados

1. **Gnome Sort** - O(n²) - Algoritmo simple que funciona como un gnomo ordenando macetas
2. **Merge Sort** - O(n log n) - Divide y conquista, muy eficiente
3. **Quick Sort** - O(n log n) promedio - Uno de los más rápidos en la práctica
4. **Radix Sort** - O(d(n+k)) - Excelente para números enteros
5. **Odd-Even Sort** - O(n²) - Ordena comparando parejas de elementos

## Archivos del Proyecto

- `Comparable.java` - Interfaz para estructuras de datos comparables
- `GnomeSort.java` - Implementación de Gnome Sort
- `MergeSort.java` - Implementación de Merge Sort
- `QuickSort.java` - Implementación de Quick Sort
- `RadixSort.java` - Implementación de Radix Sort
- `OddEvenSort.java` - Implementación de Odd-Even Sort
- `FileGenerator.java` - Utilidad para generar y leer archivos
- `Main.java` - Programa principal con menú interactivo

## Compilación

```bash
javac *.java
```

## Ejecución

```bash
java Main
```

El programa muestra un menú interactivo con las siguientes opciones:
1. Generar archivo con números aleatorios
2. Ordenar con un algoritmo específico
3. Cambiar archivo de trabajo
4. Salir

## Uso para el Proyecto

### Generar Archivo de Números
El programa puede generar archivos con hasta 3000 números aleatorios.

### Ordenar con Algoritmos
Cada algoritmo puede ser ejecutado independientemente para ordenar los números del archivo.

### Medición de Tiempos
Los tiempos de ejecución se miden externamente con tu propio método/profiler en bash.

## Características

- ✓ Programa único y simple de usar
- ✓ Menú interactivo en terminal
- ✓ Manejo de archivos para entrada/salida de datos
- ✓ Verificación automática de ordenamiento correcto
- ✓ Soporte para números positivos y negativos
- ✓ Implementaciones optimizadas de cada algoritmo
- ✓ Interfaz Comparable para estructuras de datos personalizadas

## Notas

- Radix Sort funciona mejor con números enteros
- Para arreglos muy grandes (>1000 elementos), Quick Sort y Merge Sort suelen ser los más rápidos
- Gnome Sort y Odd-Even Sort son más lentos pero más simples de entender
- La medición de tiempos debe hacerse externamente con tu propio profiler
