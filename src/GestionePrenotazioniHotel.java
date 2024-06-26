import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionePrenotazioniHotel {

    private List<Camera> camere;
    private Map<Cliente, PrenotazioniHotel> prenotazioni;

    public GestionePrenotazioniHotel() {
        camere = new ArrayList<>();
        prenotazioni = new HashMap<>();
    }

    public void aggiungiCamera(Camera camera) {
        camere.add(camera);
    }

    public void prenota(Cliente cliente, Camera c) {
       
        if (c.isDisponibile()) {
            PrenotazioniHotel prenotazione = new PrenotazioniHotel(cliente, c);
            prenotazioni.put(cliente, prenotazione);
            c.setDisponibile(false);
            return;
        }
        
        throw new IllegalStateException("Non ci sono camere disponibili.");
    }

    public void modificaPrenotazione(Cliente cliente, Camera camera) {
        PrenotazioniHotel prenotazione = prenotazioni.get(cliente);
        if (prenotazione != null) {
            Camera vecchiaCamera = prenotazione.getCamera();
            vecchiaCamera.setDisponibile(true);
            prenotazioni.remove(cliente);
            prenota(cliente, camera);
        } else {
            throw new IllegalArgumentException("Prenotazione non trovata.");
        }
    }

    public void cancellaPrenotazione(Cliente cliente) {
        PrenotazioniHotel prenotazione = prenotazioni.get(cliente);
        if (prenotazione != null) {
            Camera camera = prenotazione.getCamera();
            camera.setDisponibile(true);
            prenotazioni.remove(cliente);
        } else {
            throw new IllegalArgumentException("Prenotazione non trovata.");
        }
    }

    @Override
    public String toString() {
        return "GestionePrenotazioniHotel [camere=" + camere + ", prenotazioni=" + prenotazioni + "]";
    }

    

    
    
}
