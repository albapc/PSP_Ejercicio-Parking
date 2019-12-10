package ejercicioparking;

public class Coche extends Thread {

    private Parking parking;
    private int numCoche;
    private boolean ocupado;

    public Coche(Parking parking, int numCoche) {
        super();
        this.parking = parking;
        this.numCoche = numCoche;
    }

    @Override
    public void run() {
        ocupado = false;
        int plazas = 0;
        while (true) {
            if (ocupado) {
                try {
                    Thread.sleep((long) (Math.random() * 5000));
                    parking.salirParking(plazas, numCoche);
                    ocupado = false;
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                try {
                    Thread.sleep((long) (Math.random() * 4000));
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
                Integer resultado = parking.entrarParking(numCoche);
                if (resultado != null) {
                    plazas = resultado;
                    ocupado = true;
                }
            }
        }
    }

}
