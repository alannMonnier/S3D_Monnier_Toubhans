package com.example.tp2ex3;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class FormationTest {

    @BeforeEach
    public void init(){
        Formation formation1 = new Formation(1);
        Formation formation2 = new Formation(2);
        formation1.ajouterMatiere("Qualite dev", 12);
        formation1.ajouterMatiere("Anglais", 10);
        formation1.ajouterMatiere("Developpement web", 8);
        formation2.ajouterMatiere("Francais", 6);
        formation2.ajouterMatiere("Reseau", 9);
        formation2.ajouterMatiere("Cryptographie", 12);
    }

    @org.junit.jupiter.api.Test
    void ajouterMatiere() {
        assertEquals(formation1.getID(), 1);
    }

    @org.junit.jupiter.api.Test
    void supprimerMatiere() {
    }

    @org.junit.jupiter.api.Test
    void getMatieres() {
    }
}