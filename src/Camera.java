public class Camera {

    int numero;
    private boolean disponibile;

    public Camera(int numero, boolean disponibile) {
        this.numero = numero;
        this.disponibile = disponibile;
    }
    
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public boolean isDisponibile() {
        return disponibile;
    }
    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    @Override
    public String toString() {
        return "Camera [numero=" + numero + ", disponibile=" + disponibile + "]";
    }

    
    
}
