public class Elettore {

    private String nome;

    public Elettore(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void vota() {
        boolean voto = false;
        if (voto) {
            throw new IllegalStateException("Questo elettore ha già votato.");
        }
        voto = true;
    }

    @Override
    public String toString() {
        return "Elettore [nome=" + nome + "]";
    }

    
}
