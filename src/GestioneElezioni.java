import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GestioneElezioni {

    private Map<String, Candidato> candidati;
    private Map<String, Integer> voti;
    private Map<String, Elettore> elettori;
    
    public GestioneElezioni() {

        candidati = new HashMap<>();
        elettori = new HashMap<>();
    }

    public void aggiungiElettore(Elettore e){
        if(elettori.containsKey(e.getNome())){
            throw new IllegalStateException("L'elettore ha già votato");
        }else{
            elettori.put(e.getNome(), e);
        }
    }

    public void aggiungiCandidato(Candidato c){
        if(candidati.containsKey(c.getNome())){

            throw new IllegalStateException("L'elettore è già esistente");

        }else{
            candidati.put(c.getNome(), c);
        }
    }

     public void vota(String nomeElettore, String nomeCandidato)  {

        Elettore elettore = elettori.get(nomeElettore);
        Candidato candidato = candidati.get(nomeCandidato);

        elettore.vota();
        candidato.aumentaVoti();

    }

    public Map<String, Integer> getRisultati() {
        Map<String, Integer> risultati = new HashMap<>();
        for (Candidato c : candidati.values()) {
            risultati.put(c.getNome(), c.getVoti());
        }
        return risultati;
    }
}
