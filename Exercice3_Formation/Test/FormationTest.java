import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class FormationTest {

    public Formation formation1;
    public Formation formation2;

    @BeforeEach
    public void init(){
        formation1 = new Formation(1);
        formation2 = new Formation(2);
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
        assertEquals(formation1.getMatieres().get("Anglais"), 10);
        assertEquals(formation1.getMatieres().get("Qualite dev"), 12);
    }

    @org.junit.jupiter.api.Test
    void supprimerMatiere() {
        assertEquals(formation1.getMatieres().get("Anglais"), 10);
        formation1.supprimerMatiere("Anglais");
        assertEquals(formation1.getMatieres().get("Anglais"), null);

        assertEquals(formation2.getMatieres().get("Reseau"), 9);
        formation2.supprimerMatiere("Reseau");
        assertEquals(formation2.getMatieres().get("Reseau"), null);
    }

    @org.junit.jupiter.api.Test
    void getMatieres() {
    }
}