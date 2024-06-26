public class PrenotazioniHotel {
    
    private Cliente cliente;
    private Camera camera;

    public PrenotazioniHotel(Cliente cliente, Camera camera) {
        this.cliente = cliente;
        this.camera = camera;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Camera getCamera() {
        return camera;
    }

    @Override
    public String toString() {
        return "Prenotazioni [cliente=" + cliente + ", camera=" + camera + "]";
    }

    
}
