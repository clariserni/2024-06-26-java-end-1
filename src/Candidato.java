public class Candidato {

    private String nome;
    private int voti;

    

    public Candidato(String nome) {
        this.nome = nome;
        
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getVoti() {
        return voti;
    }
    public void setVoti(int voti) {
        this.voti = voti;
    }
   
    public void aumentaVoti(){
        voti ++;
    }
    @Override
    public String toString() {
        return "Candidato [nome=" + nome + ", voti=" + voti + "]";
    }
    
    
}
