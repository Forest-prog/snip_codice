import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Parcheggio {
    private Semaphore semaforo;

    public Parcheggio(int postiDisponibili) {
        this.semaforo = new Semaphore(postiDisponibili); // Inizializza il semaforo con i posti disponibili
    }

    public void entraNelParcheggio(String nomeAuto) {
        try {
            System.out.println(nomeAuto + " sta cercando un posto...");
            semaforo.acquire(); // Prova a prendere un posto (se non disponibile, aspetta)
            System.out.println(nomeAuto + " è entrata nel parcheggio.");

            // Simula il tempo di sosta dell'auto nel parcheggio
            TimeUnit.SECONDS.sleep((int) (Math.random() * 5) + 1);

            esciDalParcheggio(nomeAuto);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void esciDalParcheggio(String nomeAuto) {
        System.out.println(nomeAuto + " sta uscendo dal parcheggio.");
        semaforo.release(); // Libera il posto per un'altra auto
    }
}

class Auto extends Thread {
    private Parcheggio parcheggio;
    private String nomeAuto;

    public Auto(Parcheggio parcheggio, String nomeAuto) {
        this.parcheggio = parcheggio;
        this.nomeAuto = nomeAuto;
    }

    @Override
    public void run() {
        parcheggio.entraNelParcheggio(nomeAuto);
    }
}

public class SemaforiParcheggio {
    public static void main(String[] args) {
        int postiDisponibili = 4; // Numero massimo di auto nel parcheggio
        int numAuto = 4; // Numero totale di auto che vogliono parcheggiare

        Parcheggio parcheggio = new Parcheggio(postiDisponibili);

        for (int i = 1; i <= numAuto; i++) {
            new Auto(parcheggio, "Auto " + i).start();
        }
    }
}