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
        System.out.println("---------------------------");
        prenotazioniHotel();
        System.out.println("---------------------------");
        impiegatoManager();
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

        try {
            
            System.out.println(ge);

            Candidato c1 = new Candidato("mARIO");
            Candidato c2 = new Candidato("Luca");

            Elettore e1 = new Elettore("Alberto");
            Elettore e2 = new Elettore("Laura");
            Elettore e3 = new Elettore("Carla");
            

            System.out.println(ge);
            System.out.println("-------------------------------------------------------------------");
            ge.vota(e1, c2);
            System.out.println(ge);
            System.out.println("-------------------------------------------------------------------");
            ge.vota(e2, c2);
            System.out.println(ge);
            System.out.println("-------------------------------------------------------------------");
            ge.vota(e3, c1);
            System.out.println(ge);
            System.out.println("-------------------------------------------------------------------");
           

            System.out.println("Eletto: " + ge.getEletto());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void prenotazioniHotel(){
        GestionePrenotazioniHotel gph = new GestionePrenotazioniHotel();

        Camera c1 = new Camera(101, true);
        Camera c2 = new Camera(102, true);
        Camera c3 = new Camera(103, true);
        gph.aggiungiCamera(c1);
        gph.aggiungiCamera(c2);
        gph.aggiungiCamera(c3);

        Cliente cl1 = new Cliente("Mario", "Rossi");
        Cliente cl2 = new Cliente("Luca", "Bianchi");

        gph.prenota(cl1,c3);
        gph.prenota(cl2, c1);
        System.out.println(gph.toString());

        gph.modificaPrenotazione(cl2, c2);
        System.out.println(gph.toString());

        gph.cancellaPrenotazione(cl1);
        System.out.println(gph.toString());
    }

    public static void impiegatoManager(){
        Impiegato i1 = new Impiegato("Mario", 500);
        Impiegato i2 = new Impiegato("Luca", 2000);
        Impiegato i3 = new Manager("Mario", 5000, 500);

        System.out.println(i1.aumentaSalario(15));
        System.out.println(i2.aumentaSalario(20));
        System.out.println(i3.aumentaSalario(15));

    }
}
