import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GestionOrdenamiento {

    Random numeroAleatorio = new Random();

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

        long tiempo = fin - inicio;
        long segundos = tiempo / 1000000000;

        for (int i : arrayBurbuja) {

            numeros.append(i).append(" ");
        }

        numeros.append("\n")
                .append("Tiempo De Ejecucion: \n")
                .append("NanoSegundos: ").append(tiempo).append("\n")
                .append("Segundos: ").append(segundos).append("\n");

        JOptionPane.showMessageDialog(null, numeros.toString());
    }

    public void mostrarVector(int[] vector, long inicio, long fin) {

        StringBuilder numeros = new StringBuilder();

        long tiempo = fin - inicio;
        long segundos = tiempo / 1000000000;

        for (int i = 0; i < vector.length; i++) {

            numeros.append(vector[i]).append(" ");
        }

        numeros.append("\n")
                .append("Tiempo De Ejecucion: \n")
                .append("NanoSegundos: ").append(tiempo).append("\n")
                .append("Segundos: ").append(segundos).append("\n");

        JOptionPane.showMessageDialog(null, numeros.toString());
    }

    public void metodoInsercionVectores(int[] numeros) {

        for (int i = 1; i < numeros.length; ++i) {

            int clave = numeros[i];
            int j = i - 1;

            while (j >= 0 && numeros[j] > clave) {

                numeros[j + 1] = numeros[j];
                j = j - 1;
            }

            numeros[j + 1] = clave;
        }
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

        for (int i = 0; i < tope; i++) {

            int numero;

            do {

                numero = numeroAleatorio.nextInt((tope * 2) + 1);

            } while (array.contains(numero));

            array.add(numero);
        }
    }

    public void llenarVector(int tope, int[] numeros) {

        boolean[] numeroUsado = new boolean[tope];

        for (int i = 0; i < numeros.length; i++) {

            int numero;

            do {

                numero = numeroAleatorio.nextInt(tope) + 1;

            } while (numeroUsado[numero - 1]);

            numeros[i] = numero;
            numeroUsado[numero - 1] = true;
        }
    }

    public void metodoQuickSort(ArrayList<Integer> arrayQuickSort, int inicio, int fin) {

        if (inicio < fin) {

            int indicePivote = particion(arrayQuickSort, inicio, fin);
            metodoQuickSort(arrayQuickSort, inicio, indicePivote - 1);
            metodoQuickSort(arrayQuickSort, indicePivote + 1, fin);
        }
    }

    private int particion(ArrayList<Integer> arrayQuickSort, int inicio, int fin) {

        int pivote = arrayQuickSort.get(fin);
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {

            if (arrayQuickSort.get(j) <= pivote) {

                i++;
                int temporal = arrayQuickSort.get(i);

                arrayQuickSort.set(i, arrayQuickSort.get(j));
                arrayQuickSort.set(j, temporal);
            }
        }

        int temporal = arrayQuickSort.get(i + 1);

        arrayQuickSort.set(i + 1, arrayQuickSort.get(fin));
        arrayQuickSort.set(fin, temporal);

        return i + 1;
    }

    public void metodoHeapSort(ArrayList<Integer> arrayHeapSort) {

        int n = arrayHeapSort.size();

        for (int i = n / 2 - 1; i >= 0; i--) {

            ajustar(arrayHeapSort, n, i);
        }

        for (int i = n - 1; i > 0; i--) {

            int temporal = arrayHeapSort.get(0);

            arrayHeapSort.set(0, arrayHeapSort.get(i));
            arrayHeapSort.set(i, temporal);
            ajustar(arrayHeapSort, i, 0);
        }
    }

    private void ajustar(ArrayList<Integer> arrayList, int n, int i) {

        int mayor = i;
        int izquierda = 2 * i + 1;
        int derecha = 2 * i + 2;

        if (izquierda < n && arrayList.get(izquierda) > arrayList.get(mayor)) {

            mayor = izquierda;
        }

        if (derecha < n && arrayList.get(derecha) > arrayList.get(mayor)) {

            mayor = derecha;
        }

        if (mayor != i) {

            int cambio = arrayList.get(i);

            arrayList.set(i, arrayList.get(mayor));
            arrayList.set(mayor, cambio);
            ajustar(arrayList, n, mayor);
        }
    }
}