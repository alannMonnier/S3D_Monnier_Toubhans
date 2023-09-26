
public class Identite {

    public String nip;
    public String prenom;
    public String nom;

    public Identite(String nip, String prenom, String nom){
        this.nip = nip;
        this.prenom = prenom;
        this.nom = nom;
    }

    public String toString(){
        return("NIP: "+nip+" Prénom: "+prenom+" Nom: "+nom);
    }

    
}
