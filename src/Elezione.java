import java.util.HashMap;
import java.util.Map;

public class Elezione {

    // private Map<Candidato, List<Elettore>> voti = null;
    private Map<Elettore, Candidato> voti = null;

    public Elezione() {

        voti = new HashMap<>();
    }

    public Map<Elettore, Candidato> getVoti() {
        return voti;
    }

    public void vota(Elettore e, Candidato c) throws Exception {

        if (voti.containsKey(e))
            throw new Exception("L'elettore ha già votato");

        voti.put(e, c);
    }

    public Map<Candidato, Integer> getResults() {

        Map<Candidato, Integer> res = new HashMap<>();

        for (Elettore e : getVoti().keySet()) {

            Candidato c = getVoti().get(e);

            if (res.containsKey(c))
                res.put(c, res.get(c) + 1);
            else
                res.put(c, 1);
        }

        return res;
    }

    public Candidato getEletto() {

        int maxVoti = Integer.MIN_VALUE;
        Candidato eletto = null;

        Map<Candidato, Integer> res = getResults();
        for (Candidato c : res.keySet()) {

            int voti = res.get(c);

            if (voti > maxVoti) {

                maxVoti = voti;
                eletto = c;
            }
        }

        return eletto;
    }

    @Override
    public String toString() {

        String res = "Votazione:\n";

        Map<Candidato, Integer> results = getResults();
        for (Candidato c : results.keySet())
            res += c.getName() + " " + c.getSurname() + ": " + results.get(c) + " voti\n";

        return res;
    }
}
