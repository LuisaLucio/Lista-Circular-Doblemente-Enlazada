package shellsort;

/**
 *
 * @author Luisa Lucio
 */
public class ShellSort {

    // Método para implementar Shell Sort
    public static void shellSort(int[] arr) {
        int n = arr.length;

        // Inicializamos el gap dividiendo el tamaño del array por 2
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Recorremos el array desde el gap hasta el final
            for (int i = gap; i < n; i++) {
                // Guardamos el valor actual en una variable temporal
                int temp = arr[i];
                int j;
                
                // Desplazamos los elementos de la sublista que están a gap posiciones
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                
                // Colocamos el valor temporal en su posición correcta
                arr[j] = temp;
            }
        }
    }

    // Método principal para probar el algoritmo
    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3};
        System.out.println("Lista desordenada:");
        printArray(arr);

        shellSort(arr);

        System.out.println("Lista ordenada:");
        printArray(arr);
    }

    // Método para imprimir el array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}