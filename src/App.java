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

        Studente();
        System.out.println("----------------------------");
        contoBancario();
        System.out.println("---------------------------");
        elencoTelefonico();
        System.out.println("---------------------------");
        prenotazioni();
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

        System.out.println(p.prenota(1)); 
        System.out.println(p.prenota(5));

        System.out.println(p.annullaPrenotazione(1));
        System.out.println("Disponibilità: "+p.isDisponibile(15));
        System.out.println(p.toString());
    }

}
