package com.example.tp2ex3;

import java.util.*;

public class Groupe {

    private Formation formation;
    private ArrayList<Etudiant> array;

    public Groupe(Formation form){
        this.array = new ArrayList<Etudiant>();
        this.formation = form;
    }

    public void addEtudiant(Etudiant e){
        array.add(e);
    }

    public double moyGroupe(String m){

        double somme = 0;

        for(Etudiant e : array){
            //Tous les étudiants d'un meme groupe suivent les meme matieres donc pas besoin de se soucier de si ils la suivent ou pas. (Une moyenne de 0 étant peu probable)
            double moy = e.calculerMoyenne(m);
            somme += moy;
        }

        return somme/array.size();
    }

    public double moyGenerale(){

        double somme = 0;

        for(Etudiant e : array){
            double moy = e.calculerMoyenneGenerale();
            somme += moy;
        }

        return somme/array.size();
    }

    public void triAlpha(){
        Collections.sort(array);
    }

    public void triNonAlpha(){
        Collections.sort(array, Collections.reverseOrder());
    }



}
