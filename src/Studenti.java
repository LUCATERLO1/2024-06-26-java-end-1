import java.util.ArrayList;

public class Studenti {
   
    private String nome;
    private String matricola;
    private ArrayList<Integer> voti;


    
    public Studenti(String nome, String matricola) {
        this.nome = nome;
        this.matricola = matricola;
        this.voti = new ArrayList<>();
    }


    public void addVoto(int voto) {
        if (voto < 18) {
            throw new IllegalArgumentException("Non si aggiunge il voto perchè non si è passato l'esame");
        }
        if (voto > 30) {
            throw new IllegalArgumentException("Non si aggiugne il voto perchè è maggiore di 30");
        }
        System.out.println("Voto aggiunto: " + voto);
        voti.add(voto);
    }

   
    public double media() {
        if (voti.isEmpty()) {
            throw new IllegalStateException("Non ci sono voti per calcolare la media");
        }
        int sum = 0;
        for (int voto : voti) {
            sum += voto;
        }
        return (double) sum / voti.size();
    }

    public void print() {
        System.out.println("Nome: " + nome);
        System.out.println("Matricola: " + matricola);
        System.out.println("Voti: " + voti);
        System.out.println("Media: " + media());
    }

}
