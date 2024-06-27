import java.util.ArrayList;
import java.util.List;

public class ElencoTelefonico{

    private List<Contatto> contatti;

    public ElencoTelefonico() {
        
        this.contatti = new ArrayList<>();
    }
   

    public List<Contatto> getContatti() {
        return contatti;
    }

    public void setContatti(List<Contatto> contatti) {
        this.contatti = contatti;
    }

    public void aggiungiContatti(Contatto c){
       contatti.add(c);
    }

    public void rimuoviContatti(Contatto c){
        contatti.remove(c);
    }

    public Contatto cercaContatti(String data){
        for(Contatto c : contatti){
            if(c.getNome().toLowerCase().contains(data)||c.getNumero().contains(data)){
                return c;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "ElencoTelefonico [contatti=" + getContatti() + "]";
    }

    
}
