package com.example.tp2ex3;

import java.util.*;

public class Groupe {

    private formation Formation;
    private TreeSet<Etudiant> tree;

    public Groupe(Formation form){
        this.tree = new TreeSet<Etudiant>();
        this.formation = form;
    }

    public void addEtudiant(Etudiant e){
        tree.add(e);
    }

    public double moyGroupe(String m){

        double somme = 0;

        for(Etudiant e : tree){
            //Tous les étudiants d'un meme groupe suivent les meme matieres donc pas besoin de se soucier de si ils la suivent ou pas. (Une moyenne de 0 étant peu probable)
            double moy = e.calculerMoyenne(m);
            somme += moy;
        }

        return somme/tree.size();
    }

    public double moyGenerale(){

        double somme = 0;

        for(Etudiant e : tree){
            double moy = e.calculerMoyenneGenerale();
            somme += moy;
        }

        return somme/tree.size();
    }

}
