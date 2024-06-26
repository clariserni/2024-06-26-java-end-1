public class Contatto {

 /*    ES4: Elenco Telefonico
 * 
 * Implementa una classe Contatto che rappresenti un contatto telefonico con
 * nome e numero di telefono (stringa). Crea una classe ElencoTelefonico che gestisca una
 * lista di contatti. Includi metodi per aggiungere, rimuovere e cercare
 * contatti. Gestisci eventuali eccezioni relative all'inserimento di numeri di
 * telefono non validi.
 * */

    private String nome;
    private String numero;


    public Contatto(String nome, String numero) {
        setNome(nome);
        setNumero(numero);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }


    public void setNumero(String numero) {

        if (numero == null || numero.isEmpty()) {
            throw new IllegalArgumentException("Numero di telefono non valido.");
        }
        
        for (char c : numero.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Numero di telefono non valido.");
            }
        }
        
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Contatto [nome=" + getNome() + ", numero=" + getNumero() + "]";
    }

    
}
