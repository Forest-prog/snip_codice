import java.util.concurrent.Semaphore;

class Auto extends Thread {
    private int id;
    private Parcheggio parcheggio;

    public Auto(int id, Parcheggio parcheggio) {
        this.id = id;
        this.parcheggio = parcheggio;
    }

    @Override
    public void run() {
        try {
            System.out.println("Auto " + id + " sta cercando un posto...");
            parcheggio.entra(id);
            Thread.sleep(2000); // L'auto rimane parcheggiata per un po'
            parcheggio.esce(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Parcheggio {
    private Semaphore postiDisponibili;

    public Parcheggio(int numPosti) {
        this.postiDisponibili = new Semaphore(numPosti);
    }

    public void entra(int idAuto) throws InterruptedException {
        postiDisponibili.acquire(); // Aspetta se non ci sono posti liberi
        System.out.println("Auto " + idAuto + " è entrata nel parcheggio.");
    }

    public void esce(int idAuto) {
        System.out.println("Auto " + idAuto + " sta uscendo dal parcheggio.");
        postiDisponibili.release(); // Libera un posto
    }
}

public class ParcheggioMain {
    public static void main(String[] args) {
        int numPosti = 3; // Numero massimo di posti disponibili
        Parcheggio parcheggio = new Parcheggio(numPosti);

        // Creiamo 6 auto
        for (int i = 1; i <= 6; i++) {
            new Auto(i, parcheggio).start();
            try {
                Thread.sleep(500); // Simula l'arrivo scaglionato delle auto
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}