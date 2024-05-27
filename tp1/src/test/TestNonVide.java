package test;

import testEtat.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestNonVide {
    private Conteneur C;
    private Object A1, A2, B1, B2;

    // Creation d'un conteneur partiellement rempli
    @BeforeEach
    public void creerConteneurNonVide() {
        C = assertDoesNotThrow(() -> new Conteneur(5));

        A1 = new Object();
        A2 = new Object();
        B1 = new Object();
        B2 = new Object();

        assertDoesNotThrow(() -> C.ajouter(A1, B1));
        assertDoesNotThrow(() -> C.ajouter(A2, B2));

    }
    @Test
    public void testAjouterNewClef() {
        Object A3 = new Object();
        Object B3 = new Object();
        assertDoesNotThrow(() -> C.ajouter(A3, B3));
    }

    @Test
    public void testAjouterExistingClef() {
        Object newValue = new Object();
        assertDoesNotThrow(() -> C.ajouter(A1, newValue));
        assertEquals(newValue, assertDoesNotThrow(() -> C.valeur(A1)));
    }


    @Test
    public void Taillesup1() {
        // Assuming you already added A1, B1 and A2, B2 in @BeforeEach
        int size = C.taille();
        assertTrue(size > 1);
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
}
