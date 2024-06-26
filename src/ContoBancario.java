import java.util.ArrayList;
import java.util.List;

public class ContoBancario {

   /*  ES3: Simulatore di Banca
 * 
 * Definisci una classe ContoBancario con metodi per depositare denaro,
 * prelevare denaro e ottenere il saldo. Assicurati di gestire il caso in cui si
 * tenta di prelevare più denaro di quanto disponibile con un'eccezione.
 * */

    List<Integer> denaro = new ArrayList<>();
    int denaroCorrente;

    public void aggiungiDenaro(int somma){
         
        if(somma >0){
            denaro.add(somma);
            denaroCorrente+=somma;
        }else{
            System.out.println("Somma inserita negativa");
        }
    }

    public void ritiraDenaro(int somma){
        if(somma>denaroCorrente){
            throw new IllegalArgumentException("Stai cercando di prelevare troppo denaro. Mi dispiace, sei povero");
        }

        denaroCorrente-=somma;
        denaro.add(-somma);
        
    }

    public int saldo(){
        return denaroCorrente;
    }
}
