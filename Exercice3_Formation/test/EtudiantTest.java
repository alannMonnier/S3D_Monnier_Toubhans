package com.example.tp2ex3;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class EtudiantTest {


    Etudiant e1;

    /**
     * Initialise les variables pour le test
     */
    @BeforeEach
    public void init(){
        // Etudiant 1
        Identite i1 = new Identite("1", "Eleve1", "Nom 1");
        Formation f1 = new Formation(1);
        f1.ajouterMatiere("Français", 2);
        f1.ajouterMatiere("Math", 4);
        f1.ajouterMatiere("NSI", 8);
        f1.ajouterMatiere("Cine", 3);
        e1 = new Etudiant(i1, f1);

        e1.ajouterNote("Math", 15);
        e1.ajouterNote("Math", 5);
        e1.ajouterNote("NSI", 18);
    }





    /**
     * Test que la fonction ajouterNote est OK
     */
    @org.junit.jupiter.api.Test
    void test_ajouterNote_OK() {
        e1.ajouterNote("Français", 6);

        TreeMap<String, ArrayList<Double>> result = e1.getResult();
        ArrayList<Double> notes = result.get("Français");


        assertEquals(e1.getResult().containsKey("Français"), true, "La valeur devrait être présente");
        assertEquals(e1.notes("Français").contains(6.0), true, "Mauvaise valeur attendu");
    }




    /**
     * Test que la note ajouter n'est pas comprise entre 0 et 20
     */
    @org.junit.jupiter.api.Test
    void test_ajouterNoteMauvaiseValeur(){
        // Ajoute note > 20
        e1.ajouterNote("Français", 21);

        TreeMap<String, ArrayList<Double>> result = e1.getResult();
        ArrayList<Double> notes = result.get("Français");

        assertEquals(e1.getResult().containsKey("Français"), true, "La valeur devrait être présente");
        assertEquals(e1.notes("Français").contains(21), false, "Mauvaise valeur attendu");

        // Ajoute note < 0
        e1.ajouterNote("Français", -1);

        result = e1.getResult();
        notes = result.get("Français");

        assertEquals(e1.getResult().containsKey("Français"), true, "La valeur devrait être présente");
        assertEquals(e1.notes("Français").contains(-1), false, "Mauvaise valeur attendu");
    }

    // Test lorsqu'on ajoute une matière inconnue
    @org.junit.jupiter.api.Test
    void test_ajouterNote_MatiereInconnu(){
        e1.ajouterNote("Sport", 18);

        TreeMap<String, ArrayList<Double>> result = e1.getResult();

        assertEquals(e1.getResult().containsKey("Sport"), false, "La valeur devrait être présente");

    }



    // ajouter note matière qui n existe pas
    // calculerMoyenne ok
    // La matière ne possède aucune note
    @org.junit.jupiter.api.Test
    void test_calculerMoyenne_ok() {
        double moy = e1.calculerMoyenne("Math");

        assertEquals(moy, 10, "Ce n'est pas la bonne moyenne obtenue");
    }

    // Test quand la matière ne possède aucune note
    @org.junit.jupiter.api.Test
    void test_calculerMoyenne_AucuneNote(){
        double moy = e1.calculerMoyenne("Cine");

        assertEquals(moy, 0, "Ce n est pas la bonne valeur attendue");
    }

    // Test quand la matière est inexistante
    @org.junit.jupiter.api.Test
    void test_calculerMoyenne_matiereNoExistante(){
        double moy = e1.calculerMoyenne("Matiere");

        assertEquals(moy, 0, "Ce n'est pas la bonne valeur obtenue");
    }

    @org.junit.jupiter.api.Test
    void calculerMoyenneGenerale_OK() {
        double moyGeneral = e1.calculerMoyenneGenerale();

        System.out.println(moyGeneral);
    }
}