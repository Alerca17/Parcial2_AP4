import javax.swing.*;
import java.util.ArrayList;

public class Menu {

    GestionOrdenamiento ordenamiento = new GestionOrdenamiento();
    ArrayList<Integer> arrayList = new ArrayList<>();
    int opc;

    public void menuPrincipal() {

        opc = Integer.parseInt(JOptionPane.showInputDialog(null, """
                Ingresa Una Opcion
                1).Metodo Burbuja
                2).Metodo Insercion
                3).Metodo QuickSort
                4).Metodo HeapSort
                5).Salir
                """, "Menu Metodos", JOptionPane.INFORMATION_MESSAGE));

        switch (opc) {

            case 1:
                menuMetodoBurbuja();
                menuPrincipal();
                break;
            case 2:
                menuMetodoInsercion();
                menuPrincipal();
                break;

            case 3:
                menuMetodoQuickSort();
                menuPrincipal();
                break;

            case 4:
                menuMetodoHeapSort();
                menuPrincipal();
                break;

            case 5:
                System.exit(0);
                break;

            default:
                JOptionPane.showMessageDialog(null, "OPCION INCORRECTA", "ERROR", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    public void menuMetodoBurbuja() {

        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, """
                Ingresa La Cantidad
                """, "Menu Burbuja", JOptionPane.INFORMATION_MESSAGE));

        ordenamiento.llenarArrayList(cantidad, arrayList);
        long inicio = System.nanoTime();
        ordenamiento.metodoBurbuja(cantidad, arrayList);
        long fin = System.nanoTime();
        ordenamiento.mostrarArrayList(arrayList, inicio, fin);
        arrayList.clear();
    }

    public void menuMetodoInsercion() {

        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, """
                Ingresa La Cantidad
                """, "Menu Insercion", JOptionPane.INFORMATION_MESSAGE));

        ordenamiento.llenarArrayList(cantidad, arrayList);
        long inicio = System.nanoTime();
        ordenamiento.metodoInsercion(cantidad, arrayList);
        long fin = System.nanoTime();
        ordenamiento.mostrarArrayList(arrayList, inicio, fin);
        arrayList.clear();
    }

    public void menuMetodoQuickSort() {

        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, """
                Ingresa La Cantidad
                """, "Menu QuickSort", JOptionPane.INFORMATION_MESSAGE));

        ordenamiento.llenarArrayList(cantidad, arrayList);
        long inicio = System.nanoTime();
        ordenamiento.metodoQuickSort(arrayList, 0, arrayList.size() - 1);
        long fin = System.nanoTime();
        ordenamiento.mostrarArrayList(arrayList, inicio, fin);
        arrayList.clear();
    }

    public void menuMetodoHeapSort() {

        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, """
                Ingresa La Cantidad
                """, "Menu HeapSort", JOptionPane.INFORMATION_MESSAGE));

        ordenamiento.llenarArrayList(cantidad, arrayList);
        long inicio = System.nanoTime();
        ordenamiento.metodoHeapSort(arrayList);
        long fin = System.nanoTime();
        ordenamiento.mostrarArrayList(arrayList, inicio, fin);
        arrayList.clear();
    }
}
