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

  } 

}


   

