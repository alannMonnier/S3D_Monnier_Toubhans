import java.util.TreeMap;

public class Formation {

    private int id;
    private TreeMap<String, Double> matieres; // Matière => coefficient


    public Formation(int _id){
        this.id = _id;
        this.matieres = new TreeMap<>();
    }


    public void ajouterMatiere(String matiere, double coeff){
        this.matieres.put(matiere, coeff);
    }

    public void supprimerMatiere(String matiere){
        for(String mat : this.matieres.keySet()){
            if(mat.equals(matiere)){
                this.matieres.remove(mat);
                break;
            }
        }
    }

    public TreeMap<String, Double> getMatieres() {
        return matieres;
    }
}
