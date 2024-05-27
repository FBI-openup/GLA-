package test;

import testEtat.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestInit {
    private Conteneur C;

    // Objectif de test : Creation d'un conteneur de capacite > 1
    // Resultat attendu : Conteneur vide cree de la capacite passee en argument
    @Test
    public void capaciteSup1() {
        // On force le test a echouer si une exception est levee
        // On recupere le conteneur si tout se passe correctement
        C = assertDoesNotThrow(() -> new Conteneur(5));

        assertNotNull(C);

        assertTrue(C.estVide());
        assertEquals(C.taille(), 0);
        assertEquals(C.capacite(), 5);
    }
    @Test
    public void capaciteInf2() {
        assertThrows(ErreurConteneur.class, () -> new Conteneur(1));
    }
    @Test
    public void conteneurEstVideApresInitialisation() {
        C = assertDoesNotThrow(() -> new Conteneur(3));
        assertTrue(C.estVide());
    }
    @Test
    public void conteneurRedimensionerErreur() {
    	C = assertDoesNotThrow(() -> new Conteneur(3));
    	assertThrows(ErreurConteneur.class, () -> C.redimensionner(10));
    }
    @Test
    public void conteneurRazErreur() {
    	C = assertDoesNotThrow(() -> new Conteneur(3));
    	assertThrows(ErreurConteneur.class, () -> C.raz());
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
    public void test_retirer() {
    	C = assertDoesNotThrow(() -> new Conteneur(3));
    	Object A1 = new Object();
    	assertDoesNotThrow(() -> C.retirer(A1));
        assertFalse(C.present(A1));
    }
    @Test
    public void testAjouterNewClef() {
    	C = assertDoesNotThrow(() -> new Conteneur(3));
        Object A3 = new Object();
        Object B3 = new Object();
        assertDoesNotThrow(() -> C.ajouter(A3, B3));
    }
    
}

