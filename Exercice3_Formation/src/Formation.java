import java.util.TreeMap;

/**
 * Représente une formation
 */
public class Formation {

    /**
     * Declarations des attributs
     */
    private int id; // identifiant formation
    private TreeMap<String, Double> matieres; // Matière => coefficient


    /**
     * Constructeur de la classe Formation prend un id en paramètre
     * @param _id représente un identifiant d'information
     */
    public Formation(int _id){
        this.id = _id;
        this.matieres = new TreeMap<>();
    }


    /**
     * Ajoute une matière dans la TreeMap de matière
     * @param matiere une matière présente dans la formation
     * @param coeff le coefficient de la matière
     */
    public void ajouterMatiere(String matiere, double coeff){
        this.matieres.put(matiere, coeff);
    }


    /**
     * Supprime une matière de la TreeMap matières de la formation
     * @param matiere une matière présente dans la formation
     */
    public void supprimerMatiere(String matiere){
        for(String mat : this.matieres.keySet()){
            if(mat.equals(matiere)){
                this.matieres.remove(mat);
                break;
            }
        }
    }


    /**
     * Getter de la treemap de matières de la formation
     * @return la TreeMap contenant les couples (matière => coefficient)
     */
    public TreeMap<String, Double> getMatieres() {
        return matieres;
    }
}
