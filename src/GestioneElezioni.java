import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GestioneElezioni {


    private Map<Elettore, Candidato> voti;
   
    public GestioneElezioni() {

        voti = new HashMap<>();
       
    }

    public Map<Elettore, Candidato> getVoti(){
        return voti;
    } 


    public void vota(Elettore e, Candidato c){
        if(voti.containsKey(e)){
            throw new IllegalStateException("L'elettore ha già votato");
        }else{
            voti.put(e, c);
        }
    }

   

    public Map<Candidato, Integer> getRisultati() {
        Map<Candidato, Integer> risultati = new HashMap<>();
        for (Elettore e : getVoti().keySet()) {
            Candidato c = getVoti().get(e);

            if(risultati.containsKey(c))
                risultati.put(c, risultati.get(c)+1);
            else
                risultati.put(c, 1);
        }
        return risultati;
    }

    public Candidato getEletto() {

        int maxVoti = Integer.MIN_VALUE;
        Candidato eletto = null;

        Map<Candidato, Integer> res = getRisultati();
        for (Candidato c : res.keySet()) {

            int voti = res.get(c);

            if (voti > maxVoti) {

                maxVoti = voti;
                eletto = c;
            }
        }

        return eletto;
    }

    @Override
    public String toString() {

        String res = "Votazione:\n";

        Map<Candidato, Integer> results = getRisultati();
        for (Candidato c : results.keySet())
            res += c.getNome() +  ": " + results.get(c) + " voti\n";

        return res;
    }
}
