public class App {
    

/**
 * TODO:
 * 
 * ES0: Creare un repository su GitHub con il seguente nome:
 * 2024-06-26-java-end-1
 * 
 * Caricare tutti gli esercizi in un unico progetto sulla stessa repo
 * 
 * 
 * ES1: Sistema di Prenotazioni
 * 
 * Crea una classe Prenotazione che possa essere utilizzata da un teatro per
 * tenere traccia delle prenotazioni dei posti. Utilizza un array di booleani
 * per rappresentare i posti: true se il posto è prenotato, false altrimenti.
 * Implementa metodi per prenotare un posto, annullare la prenotazione e
 * verificare se un o piu' posti sono disponibili.
 * 
 * ---------------------------------------------------------------------------
 * 
 * ES2: Registro Studenti
 * 
 * Crea una classe Studente con attributi come nome, matricola, e voti (usa un
 * ArrayList). Aggiungi metodi per aggiungere voti, calcolare la media dei voti,
 * e stampare i dettagli dello studente. Implementa la gestione delle eccezioni
 * per evitare errori nell'inserimento dei voti.
 * 
 * ---------------------------------------------------------------------------
 * 
 * ES3: Simulatore di Banca
 * 
 * Definisci una classe ContoBancario con metodi per depositare denaro,
 * prelevare denaro e ottenere il saldo. Assicurati di gestire il caso in cui si
 * tenta di prelevare più denaro di quanto disponibile con un'eccezione.
 * 
 * ---------------------------------------------------------------------------
 * 
 * ES4: Elenco Telefonico
 * 
 * Implementa una classe Contatto che rappresenti un contatto telefonico con
 * nome e numero di telefono (stringa). Crea una classe ElencoTelefonico che gestisca una
 * lista di contatti. Includi metodi per aggiungere, rimuovere e cercare
 * contatti. Gestisci eventuali eccezioni relative all'inserimento di numeri di
 * telefono non validi.
 * 
 * ---------------------------------------------------------------------------
* 
* ES5: Sistema di Votazione
* 
* Crea classi per Candidato e Elettore, dove ogni Elettore può votare per un
* Candidato. Implementa un meccanismo usando mappe per tenere traccia dei voti
* ricevuti da ogni candidato. Assicurati di gestire le eccezioni per casi come
* doppi voti o voti a candidati non esistenti.
* 
* ---------------------------------------------------------------------------
* 
* ES6: Sistema di Prenotazione Hotel
* 
* Definisci classi per Camera, Cliente, e Prenotazione. Utilizza una mappa per
* associare clienti a prenotazioni e una lista di camere disponibili.
* Implementa metodi per effettuare, modificare e cancellare prenotazioni,
* assicurandoti di gestire eccezioni come camere non disponibili o
* cancellazioni tardive.
* 
* ---------------------------------------------------------------------------
* 
* ES7: Impiegato e Manager
* 
* Crea una classe Impiegato con attributi come nome, salario e metodi per
* aumentaSalario(int percentuale). Deriva da questa una classe Manager che
* aggiunge l'attributo bonus. Il metodo aumentaSalario del manager dovrebbe
* considerare anche il bonus nell'aumento. Mostra come puoi utilizzare il
* polimorfismo per gestire diversi tipi di impiegati in un array di tipo
* Impiegato.
* 
* ---------------------------------------------------------------------------
* 
* ES8: Sistema di Prenotazione Alberghiera
* 
* Progetta una classe astratta CameraAlbergo con metodi come calcolaCosto() e
* numeroLetti(). Deriva da questa diverse classi specifiche come CameraSingola,
* CameraDoppia e Suite. Implementa calcolaCosto in modo diverso per ogni tipo
* di camera. Utilizza una collezione per gestire tutte le camere disponibili in
* un albergo.
* 
* ---------------------------------------------------------------------------

*/
 public static void main(String[] args) throws Exception {
        
    // test esercizio 1


    System.out.println("--------------------");
    Prenotazioni teatro = new Prenotazioni(18);
    teatro.prenota();
    teatro.prenota();
    teatro.prenota();
    teatro.annulla(3);
    teatro.disponibili(1);
    teatro.disponibili(14);
    System.out.println("--------------------");


// test esercizio 2
 
    
    Studenti studente = new Studenti("Luca Terlizzi", "8234513887");
    studente.addVoto(30);
    studente.addVoto(18);
    try {
        studente.print();
        studente.addVoto(3);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    System.out.println("\n--------------------\n");


    // test esercizio 3


    ContoBancario conto = new ContoBancario();

    conto.addMoney(200.0);
    System.out.println("Saldo dopo il deposito: " + conto.getConto());

    try {
        conto.retrieveMoney(100.0);
        System.out.println("Saldo dopo il prelievo: " + conto.getConto());
    } catch (IllegalArgumentException e) {
        System.out.println("Impossibile prelevare denaro: " + e.getMessage());
    }

    try {
        conto.retrieveMoney(140.0);
        System.out.println("Saldo dopo il secondo prelievo: " + conto.getConto());
    } catch (IllegalArgumentException e) {
        System.out.println("Impossibile prelevare denaro: " + e.getMessage());
    }

    try {
        conto.addMoney(-40.0);
        System.out.println("Saldo dopo l'aggiunta di denaro negativo: " + conto.getConto());
    } catch (IllegalArgumentException e) {
        System.out.println("Impossibile aggiungere denaro negativo: " + e.getMessage());
    }
    System.out.println("\n--------------------\n");




    // test esercizio 4
    
    ElencoTelefonico elenco = new ElencoTelefonico();
   

    Contatto contatto1 = new Contatto("Paulo Dybala", "3333333333");
    Contatto contatto2 = new Contatto("Gainluca Mancini", "3467878999");

    elenco.addContatto(contatto1);
    elenco.addContatto(contatto2);

    Contatto risultatoRicercaNome = elenco.searchContatto("Paulo Dybala");
    if (risultatoRicercaNome != null) {
        System.out.println("Contatto trovato per nome: " + risultatoRicercaNome.getNome() + ", Numero di telefono: " + risultatoRicercaNome.getNumeroDiTelefono());
    } else {
        System.out.println("Contatto non trovato per nome.");
    }

    Contatto risultatoRicercaNumero = elenco.searchContattoWithNumber("3467878999");
    if (risultatoRicercaNumero != null) {
        System.out.println("Contatto trovato per numero di telefono: " + risultatoRicercaNumero.getNome() + ", Numero di telefono: " + risultatoRicercaNumero.getNumeroDiTelefono());
    } else {
        System.out.println("Contatto non trovato per numero di telefono.");
    }

    elenco.removeContatto(contatto1);
    System.out.println("Elenco dopo la rimozione");
    for (Contatto contatto : elenco.getListaDiContatti()) {
        System.out.println(contatto.getNome() + ", " + contatto.getNumeroDiTelefono());
    }

    try {
        elenco.addContatto(new Contatto(null, null));
    } catch (IllegalArgumentException e) {
        System.out.println("Impossibile aggiungere contatto: " + e.getMessage());
    }

    try {
        elenco.removeContatto(new Contatto(null, null));
    } catch (IllegalArgumentException e) {
        System.out.println("Impossibile rimuovere contatto: " + e.getMessage());
    }
    System.out.println("\n--------------------\n");
   



    // test esercizio 5

   

        try {
            Elezione e = new Elezione();
            System.out.println(e);

            Candidato c1 = new Candidato("Stephan", "ElSharawy", "123456");
            Candidato c2 = new Candidato("Nicola", "Zalewsky", "654321");

            Elettore e1 = new Elettore("Lameck", "Banda", "abcdef");
            Elettore e2 = new Elettore("Razvan", "Marin", "ghijkl");
            Elettore e3 = new Elettore("Dusan", "Vlahovic", "mnopqr");
            Elettore e4 = new Elettore("Milan", "Djuric", "stuvwx");
            Elettore e5 = new Elettore("Loftus", "Cheek", "yz1234");

            System.out.println("-------------------------------------------------------------------");
            System.out.println("c1: " + c1);
            System.out.println("-------------------------------------------------------------------");
            System.out.println("c2: " + c2);
            System.out.println("-------------------------------------------------------------------");
            System.out.println("e1: " + e1);
            System.out.println("-------------------------------------------------------------------");
            System.out.println("e2: " + e2);
            System.out.println("-------------------------------------------------------------------");
            System.out.println("e3: " + e3);
            System.out.println("-------------------------------------------------------------------");
            System.out.println("e4: " + e4);
            System.out.println("-------------------------------------------------------------------");
            System.out.println("e5: " + e5);
            System.out.println("-------------------------------------------------------------------");

            System.out.println(e);
            System.out.println("-------------------------------------------------------------------");
            e.vota(e1, c2);
            System.out.println(e);
            System.out.println("-------------------------------------------------------------------");
            e.vota(e2, c2);
            System.out.println(e);
            System.out.println("-------------------------------------------------------------------");
            e.vota(e3, c1);
            System.out.println(e);
            System.out.println("-------------------------------------------------------------------");
            e.vota(e4, c1);
            System.out.println(e);
            System.out.println("-------------------------------------------------------------------");
            e.vota(e5, c1);
            System.out.println(e);
            System.out.println("-------------------------------------------------------------------");

            System.out.println("Eletto: " + e.getEletto());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    




    // test esercizio 6



        Camera c1 = new Camera(1, "311");
        Camera c2 = new Camera(1, "312");
        Camera c3 = new Camera(2, "313");
        Camera c4 = new Camera(2, "314");
        Camera c5 = new Camera(3, "315");

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);

        System.out.println("-------------------------------------------------------------------");


        Cliente cl1 = new Cliente("Ciccio", "Caputo", "123456");
        Cliente cl2 = new Cliente("Oliver", "Giroud", "654321");
        Cliente cl3 = new Cliente("Nicolo", "Barella", "abcdef");

        System.out.println(cl1);
        System.out.println(cl2);
        System.out.println(cl3);

        System.out.println("-------------------------------------------------------------------");

        Prenotazione p1 = new Prenotazione(c1, cl1);
        Prenotazione p2 = new Prenotazione(c5, cl3);
        Prenotazione p3 = new Prenotazione(c2, cl2);
        Prenotazione p4 = new Prenotazione(c3, cl1);
        Prenotazione p5 = new Prenotazione(c4, cl3);

        System.out.println(p1);
        System.out.println("-------------------------------------------------------------------");
        System.out.println(p2);
        System.out.println("-------------------------------------------------------------------");
        System.out.println(p3);
        System.out.println("-------------------------------------------------------------------");
        System.out.println(p4);
        System.out.println("-------------------------------------------------------------------");
        System.out.println(p5);
        System.out.println("-------------------------------------------------------------------");
    }


}


   

