import java.util.HashMap;
import java.util.Map;

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
 * POMERIGGIO
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
 */
    public static void main(String[] args) throws Exception {

        Studente();
        System.out.println("----------------------------");
        contoBancario();
        System.out.println("---------------------------");
        elencoTelefonico();
        System.out.println("---------------------------");
        prenotazioni();
        System.out.println("---------------------------");
        elezioni();
    }

    public static void Studente() {

        Studente s1 = new Studente("Mario Rossi", 600968);

        try{

        s1.aggiungiVoto(30);
        s1.aggiungiVoto(28);
        s1.aggiungiVoto(25);

        }catch(IllegalArgumentException e){

            System.out.println(e.getMessage());
        }

        double media = s1.calcoloMedia();
        System.out.println("Media voti: "+ media);

        System.out.println(s1.toString());
    }


    public static void contoBancario(){
        ContoBancario c1 = new ContoBancario();

        c1.aggiungiDenaro(-50);
        c1.aggiungiDenaro(100);

        try {
            c1.ritiraDenaro(60);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

       System.out.println("Saldo: "+c1.saldo());
    }

    public static void elencoTelefonico(){
        Contatto c1 = new Contatto("Clarissa", "123456789");
        Contatto c2 = new Contatto("Mario", "456789");

        ElencoTelefonico elenco = new ElencoTelefonico();

        try {
            elenco.aggiungiContatti(c1);
            elenco.aggiungiContatti(c2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        elenco.rimuoviContatti(c2);

        System.out.println(elenco.toString());

        Contatto cerco = elenco.cercaContatti("Clarissa");
        System.out.println(cerco);
    }

    public static void prenotazioni(){
         Prenotazione p = new Prenotazione();

        try {
            System.out.println(p.prenota(1)); 
            System.out.println(p.prenota(5));
        } catch (IllegalArgumentException e) {

           System.out.println(e.getMessage());
        }
       
        try {
            System.out.println(p.annullaPrenotazione(1));
        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
        

        try {
            System.out.println("Disponibilità: "+p.isDisponibile(15));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println(p.toString());
    }

    public static void elezioni(){
        
        GestioneElezioni ge = new GestioneElezioni();

        ge.aggiungiCandidato(new Candidato("Stronzo1"));
        ge.aggiungiCandidato(new Candidato("stronzo2"));

        ge.aggiungiElettore(new Elettore("Luca"));
        ge.aggiungiElettore(new Elettore("Mario"));

        try {
            ge.vota("Luca", "Stronzo1");
            ge.vota("Mario", "Stronzo1");
            ge.vota("Mario", "Stronzo1");

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(ge.getRisultati());

        
    }
}
