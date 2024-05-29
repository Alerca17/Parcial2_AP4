import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GestionOrdenamiento {

    public void metodoBurbuja(int tope, ArrayList<Integer> arrayBurbuja) {

        for (int i = 0; i < tope - 1; i++) {

            for (int j = 0; j < tope - 1 - i; j++) {

                if (arrayBurbuja.get(j) > arrayBurbuja.get(j + 1)) {

                    Collections.swap(arrayBurbuja, j, j + 1);
                }
            }
        }
    }

    public void mostrarArrayList(ArrayList<Integer> arrayBurbuja, long inicio, long fin) {

        StringBuilder numeros = new StringBuilder();

        for (int i : arrayBurbuja) {

            numeros.append(i + " ");

        }

        numeros.append("\n").append("Tiempo De Ejecucion: \n " + "NanoSegundos: " + (fin - inicio) + "\n" + " Segundos: " + (fin - inicio) / 1000000000 + "\n");
        JOptionPane.showMessageDialog(null, numeros.toString());
    }

    public void metodoInsercion(int tope, ArrayList<Integer> arrayInsercion) {

        for (int i = 1; i < tope; ++i) {

            int clave = arrayInsercion.get(i);
            int j = i - 1;

            while (j >= 0 && arrayInsercion.get(j) > clave) {

                arrayInsercion.set(j + 1, arrayInsercion.get(j));
                j = j - 1;
            }
            arrayInsercion.set(j + 1, clave);
        }
    }

    public void llenarArrayList(int tope, ArrayList<Integer> array) {

        Random numeroAleatorio = new Random();

        for (int i = 0; i < tope; i++) {

            int numero;

            do {

                numero = numeroAleatorio.nextInt((tope * 2) + 1);

            } while (array.contains(numero));

            array.add(numero);
        }
    }

    public void metodoQuickSort(ArrayList<Integer> arrayQuickSort, int inicio, int fin) {

        if (inicio < fin) {

            int indicePivote = particion(arrayQuickSort, inicio, fin);
            metodoQuickSort(arrayQuickSort, inicio, indicePivote - 1);
            metodoQuickSort(arrayQuickSort, indicePivote + 1, fin);
        }
    }

    private static int particion(ArrayList<Integer> arrayQuickSort, int inicio, int fin) {

        int pivote = arrayQuickSort.get(fin);
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {

            if (arrayQuickSort.get(j) <= pivote) {

                i++;
                int temp = arrayQuickSort.get(i);
                arrayQuickSort.set(i, arrayQuickSort.get(j));
                arrayQuickSort.set(j, temp);
            }
        }

        int temp = arrayQuickSort.get(i + 1);
        arrayQuickSort.set(i + 1, arrayQuickSort.get(fin));
        arrayQuickSort.set(fin, temp);

        return i + 1;
    }

    public void metodoHeapSort(ArrayList<Integer> arrayHeapSort) {

        int n = arrayHeapSort.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arrayHeapSort, n, i);
        }

        for (int i = n - 1; i > 0; i--) {

            int temp = arrayHeapSort.get(0);
            arrayHeapSort.set(0, arrayHeapSort.get(i));
            arrayHeapSort.set(i, temp);
            heapify(arrayHeapSort, i, 0);
        }
    }

    private static void heapify(ArrayList<Integer> arrayList, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arrayList.get(left) > arrayList.get(largest)) {

            largest = left;
        }

        if (right < n && arrayList.get(right) > arrayList.get(largest)) {

            largest = right;
        }

        if (largest != i) {

            int swap = arrayList.get(i);
            arrayList.set(i, arrayList.get(largest));
            arrayList.set(largest, swap);

            heapify(arrayList, n, largest);
        }
    }
}