package ejercicioparking;

/**
 *
 * @author Alba
 */
public class Parking {

    private final Integer[] plazasParking;

    public Parking(int numeroCoches) {

        plazasParking = new Integer[numeroCoches];
    }

    public synchronized void salirParking(int numPlazas, int numCoche) {

        plazasParking[numPlazas] = null;
        System.out.println("SALIDA: Coche " + (numCoche + 1) + " saliendo.");
        mostrarPlazas();
    }

    public synchronized Integer entrarParking(int numCoche) {

        for (int i = 0; i < plazasParking.length; i++) {
            if (plazasParking[i] == null) {
                plazasParking[i] = numCoche;
                System.out.println("ENTRADA: Coche " + (numCoche + 1) + " aparca en " + i + ".");
                mostrarPlazas();
                return i;
            }
        }
        return null;
    }

    public void mostrarPlazas() {
        int plazasLibres = 0;
        System.out.print("Parking: ");
        for (Integer plaza : plazasParking) {
            if (plaza == null) {
                plazasLibres++;
                plaza = 0;
                System.out.print("[" + plaza + "]");
            } else {
                System.out.print("[" + (plaza + 1) + "]");
            }
        }
        System.out.println("\nPlazas libres: " + plazasLibres);
    }
}
