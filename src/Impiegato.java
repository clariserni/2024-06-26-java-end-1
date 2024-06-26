public class Impiegato {
    private String nome;
    private double salario;

    public Impiegato(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public double aumentaSalario(int percentuale) {
        if (percentuale > 0) {
            double nuovoSalario = salario += salario * percentuale / 100;
            return nuovoSalario;
        } else {
            throw new IllegalArgumentException("La percentuale deve essere positiva.");
        }
        
    }

    @Override
    public String toString() {
        return "Impiegato: " + nome + ", Salario: " + salario;
    }
}
