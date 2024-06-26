public class Manager extends Impiegato{

    private double bonus;

    public Manager(String nome, double salario, double bonus) {
        super(nome, salario);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double aumentaSalario(int percentuale) {
        if (percentuale > 0) {
            double salarioBonus = getSalario() + bonus;
            double nuovoSalarioConBonus = salarioBonus + (salarioBonus * percentuale / 100);
            return nuovoSalarioConBonus;
        } else {
            throw new IllegalArgumentException("La percentuale deve essere positiva.");
        }
    }

    @Override
    public String toString() {
        return "Manager: " + getNome() + ", Salario: " + getSalario() + ", Bonus: " + bonus;
    }

    

}
