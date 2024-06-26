public class Prenotazioni {


    private boolean[] posti;

    public Prenotazioni(int size) {
        posti = new boolean[size];
    }

    public boolean prenota() {
        for (int i = 0; i < posti.length; i++) {
            if (!posti[i]) {
                posti[i] = true;
                System.out.println("Posto prenotato " + i);
                return true;
            }
        }
        System.out.println("Non ci sono posti disponibili");
        return false;
    }

    

    public void annulla(int posto) {
        if (posto < 0 || posto >= posti.length) {
            System.out.println("Posto non valido");
            return;
        }
        if (posti[posto]) {
            posti[posto] = false;
            System.out.println("Prenotazione annullata " + posto);
        } else {
            System.out.println("Posto non prenotato");
        }
    }

    

    public void disponibili(int postiDaPrenotare) {
        int count = 0;
        for (int i = 0; i < posti.length; i++) {
            if (!posti[i]) {
                count++;
            }
        }
        if (postiDaPrenotare <= count) {
            System.out.println("Ci sono " + count + " posti disponibili");
        } else {
            System.out.println("Non ci sono posti disponibili");
            
        }
    }

}
