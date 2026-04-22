public class ejer2 {
    
    public int busquedaBinariaRecursiva(int[] arr, int X, int inicio, int fin) {
        // Caso base: no se encontró
        if (inicio > fin) {
            return -1;
        }

        int medio = (inicio + fin) / 2;

        if (arr[medio] == X) {
            return medio; // encontrado
        } else if (X > arr[medio]) {
            return busquedaBinariaRecursiva(arr, X, medio + 1, fin);
        } else {
            return busquedaBinariaRecursiva(arr, X, inicio, medio - 1);
        }
    }
    

    public void decimalABinario(int n) {
        if (n == 0) {
            return;
        }
        decimalABinario(n / 2);
        System.out.print(n % 2);
    }

   public boolean posIgual(int[] arr, int i) {
        // Caso base: llegamos al final
        if (i >= arr.length) {
            return false;
        }

        // Si encontramos coincidencia
        if (arr[i] == i) {
            return true;
        }

        // Llamada recursiva avanzando
        return posIgual(arr, i + 1);
    } 
}
