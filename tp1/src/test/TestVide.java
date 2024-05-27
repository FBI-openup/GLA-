package test;

import testEtat.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestVide {
    private Conteneur C;

    // Creation d'un conteneur vide
    @BeforeEach
    public void creerConteneurVide() {
        C = assertDoesNotThrow(() -> new Conteneur(10));
    }

    // Objectif de test : Remise a zero d'un conteneur vide
    // Resultat attendu : Remise a zero impossible, levee de l'exception ErreurConteneur
    @Test
    public void razVide() {
        // on force le test a echouer si aucune exception n'est levee
        // si une exception de type ErreurConteneur est levee, le test reussit
        assertThrows(ErreurConteneur.class, () -> C.raz());

        // on verifie que le conteneur n'a pas ete modifie
        assertTrue(C.estVide());
        assertEquals(C.taille(), 0);
        assertEquals(C.capacite(), 10);
    }
    @Test
    public void test_Present() {
    	C = assertDoesNotThrow(() -> new Conteneur(3));
    	Object A1 = new Object();
        Object B1 = new Object();
        assertEquals(false, C.present(A1));
        assertDoesNotThrow(() -> C.ajouter(A1, B1));
        assertEquals(true, C.present(A1));
    }
    @Test
    public void retirerVide() {
        Object key = new Object();

        assertDoesNotThrow(() -> C.retirer(key));

        assertTrue(C.estVide());
        assertEquals(C.taille(), 0);
    }

    @Test
    public void ajouterVide() {
        Object key = new Object();
        Object value = new Object();

        assertDoesNotThrow(() -> C.ajouter(key, value));

        assertFalse(C.estVide());
        assertEquals(C.taille(), 1);
    }
}
