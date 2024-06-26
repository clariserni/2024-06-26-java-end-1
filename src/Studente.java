import java.util.ArrayList;

public class Studente {

    private String nome;
    private int matricola;
    private ArrayList <Integer> voti;


    public Studente(String nome, int matricola) {
        this.nome = nome;
        this.matricola = matricola;
        this.voti = new ArrayList<>();
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getMatricola() {
        return matricola;
    }
    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }
    public ArrayList<Integer> getVoti() {
        return voti;
    }
    public void setVoti(ArrayList<Integer> voti) {
        this.voti = voti;
    }
    

    public void aggiungiVoto(int voto){
        if (voto < 0 || voto > 30) {
            throw new IllegalArgumentException("Il voto deve essere compreso tra 0 e 30.");
        }
        voti.add(voto);
    }

    public double calcoloMedia(){

        int somma = 0;
        for(int v: voti){
           somma+=v;
        }

        return somma/voti.size();
    }
    @Override
    public String toString() {
        return "Studente [nome:" + nome + ", matricola:" + matricola + ", voti:" + voti + "]";
    }

    
}
