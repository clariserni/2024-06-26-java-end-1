import java.util.Arrays;

public class Prenotazione {

   private boolean [] posti;

    public Prenotazione() {
        this.posti = new boolean[30];
    }

    public boolean prenota(int numeroPosto){
        if(numeroPosto<0 || numeroPosto >= posti.length){
            throw new IllegalArgumentException("Posto non valido");
        }

        if(!posti[numeroPosto]){
            posti[numeroPosto] = true;
            return true;
        }
        return false;

    }

    public boolean annullaPrenotazione(int numeroPosto){
        if (numeroPosto < 0 || numeroPosto >= posti.length) {
            throw new IllegalArgumentException("Posto non valido.");
        }
        if (posti[numeroPosto]) {
            posti[numeroPosto] = false;
            return true;
        }
        return false;
    }

    public boolean isDisponibile(int numeroPosto){
        if (numeroPosto < 0 || numeroPosto >= posti.length) {
            throw new IllegalArgumentException("Posto non valido.");
        }

        if (posti[numeroPosto]) 
            return false;
        else 
            return true;
        
    }

    @Override
    public String toString() {
        return "Prenotazione [posti=" + Arrays.toString(posti) + "]";
    }

    
    

    
}
