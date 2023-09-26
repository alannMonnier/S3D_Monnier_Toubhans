import java.util.*;
public class Etudiant implements Comparable<Etudiant>{

    public Identite id;
    public Formation form;
    public TreeMap<String, ArrayList<Double>> result;

    public Etudiant(Identite iden, Formation format){

        this.id = iden;
        this.form = format;


        for(String s : form.getMatieres().keySet()){
            result.put(s, new ArrayList<>());
        }

    }

    public void ajouterNote(String mat, double note){

        if(note > 20)note = 20;
        if(note < 0)note = 0;

        if(result.containsKey(mat)){
            ArrayList<Double> arraynote = result.get(mat);
            arraynote.add(note);
            result.put(mat, arraynote);
        }
        else{
            System.out.println("La matière: "+mat+" n'est pas suivie par l'étudiant");
        }
    }

    public double calculerMoyenne(String matiere){

        double res = 0;

        if(result.containsKey(matiere)){
            ArrayList<Double> arraynote = result.get(matiere);
            if(arraynote.size() != 0){
            for(double note : arraynote){
                res += note;
            }
            res = res/arraynote.size();
            return res;
            }
            else{
                System.out.println("Attention, la matière: "+matiere+" ne possède aucune note");
                return 0;
            }
        }
        else{
            System.out.println("La matière: "+matiere+" n'est pas suivie par l'étudiant");
            return 0;
        }
    }

    public double calculerMoyenneGenerale(){

        double sommecoeff = 0;
        double somme = 0;
        double coeff;

        Set<String> mat = result.keySet();
        TreeMap<String, Double> tree = form.getMatieres();

        for(String n : mat){

            if(calculerMoyenne(n) == 0){
                coeff = 0;
            }
            else{
                coeff = tree.get(n);
            }

            somme =+ calculerMoyenne(n)*coeff;
            sommecoeff =+ coeff;
        }

        return (somme/sommecoeff);
    }



    public TreeMap<String, ArrayList<Double>> getResult() {
        return result;
    }

    public ArrayList<Double> notes(String cle) {
        return result.get(cle);
    }

    @Override
    public int compareTo(Etudiant o) {
        if(this.id.nom.compareTo(o.id.nom) > 0){
            return 1;
        }
        else if (this.id.nom.compareTo(o.id.nom) < 0) {
            return -1;
        }
        else{
            if(this.id.prenom.compareTo(o.id.prenom) > 0){
                return 1;
            }
            else if (this.id.prenom.compareTo(o.id.prenom) < 0) {
                return -1;
            }
            else{
                return 0;
            }
        }

    }
}
