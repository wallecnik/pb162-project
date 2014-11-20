package cz.muni.fi.pb162.project.test;

import cz.muni.fi.pb162.project.test.BasicRulesTester;
import cz.muni.fi.pb162.project.geometry.Circle;
import cz.muni.fi.pb162.project.geometry.SimplePolygon;
import cz.muni.fi.pb162.project.geometry.CollectionPolygon;
import cz.muni.fi.pb162.project.geometry.Color;
import cz.muni.fi.pb162.project.geometry.Colored;
import cz.muni.fi.pb162.project.geometry.GeneralRegularPolygon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 */
public class ProjectTest {
    
    @Test 
    public void task01() {
        Vertex2D v1 = new Vertex2D(1.01, -1.01);
        Vertex2D v2 = new Vertex2D(1.01, -1.01);
        Vertex2D v3 = new Vertex2D(1.0, -1.0);
        
        assertTrue("Spatna implementace rovnosti -- porovnani na sebe sama", v1.equals(v1));
        assertTrue("Spatna implementace rovnosti -- porovnani se stejnym vrcholem", v1.equals(v2));
        assertFalse("Spatna implementace rovnosti -- porovnani s odlisnym vrcholem", v1.equals(v3));
        try {
            assertFalse("Spatna implementace rovnosti -- porovnani s null objektem", v1.equals(null));
        } catch (Exception ex) {
            fail("Neocekavana vyjimka pri porovnavani vrcholu s null objektem: " + ex);
        }
        
        assertEquals("Spatna implementace hashovaci metody", v1.hashCode(), v2.hashCode());
    }

    @Test 
    public void task02() {
        assertTrue("Chybna hlavicka tridy", SimplePolygon.class.isAssignableFrom(CollectionPolygon.class));
        
        BasicRulesTester.testMethodsAndAttributes(CollectionPolygon.class);
        
        BasicRulesTester.testNonAbstractMethod(CollectionPolygon.class, "getVertex", int.class);
        BasicRulesTester.testNonAbstractMethod(CollectionPolygon.class, "getNumVertices", (Class<?>[]) null);
        BasicRulesTester.testNonAbstractMethod(CollectionPolygon.class, "getVertices", (Class<?>[]) null);
        
        BasicRulesTester.testRedundantMethod(CollectionPolygon.class, "getArea", (Class<?>[]) null);
        BasicRulesTester.testRedundantMethod(CollectionPolygon.class, "getWidth", (Class<?>[]) null);
        BasicRulesTester.testRedundantMethod(CollectionPolygon.class, "getHeight", (Class<?>[]) null);
        BasicRulesTester.testRedundantMethod(CollectionPolygon.class, "getLength", (Class<?>[]) null);
        BasicRulesTester.testRedundantMethod(CollectionPolygon.class, "toString", (Class<?>[]) null);
        
        try {
            new CollectionPolygon(null);
            fail("Konstruktor CollectionPolygon nevyhazuje pozadovanou vyjimku");
        } catch(NullPointerException ex) {
            // ok
        } catch(IllegalArgumentException ex) {
            // ok
        } catch(Exception ex) {
            fail("Neocekavana vyjimka " + ex + " pri volani konstruktoru CollectionPolygon(null)");
        }
        
        try {
            new CollectionPolygon(new Vertex2D[] {new Vertex2D(-1,0), null, new Vertex2D(1,0)});
            fail("Konstruktor CollectionPolygon nevyhazuje pozadovanou vyjimku");
        } catch(NullPointerException ex) {
            // ok
        } catch(IllegalArgumentException ex) {
            // ok
        } catch(Exception ex) {
            fail("Neocekavana vyjimka " + ex + " pri volani konstruktoru s null vrcholem");
        }
        
        Vertex2D[] aPol = {new Vertex2D(-1,0), new Vertex2D(0,-1), new Vertex2D(0,1)};
        CollectionPolygon pol = new CollectionPolygon(aPol);
        try {
            assertTrue("Volani getVertex() vraci chybny vysledek", pol.getVertex(0).getX() == -1.0);
            assertTrue("Volani getVertex() vraci chybny vysledek", pol.getVertex(0).getY() == 0.0);
            assertTrue("Volani getVertex() vraci chybny vysledek", pol.getVertex(1).getX() == 0.0);
            assertTrue("Volani getVertex() vraci chybny vysledek", pol.getVertex(1).getY() == -1.0);
            assertTrue("Volani getVertex() vraci chybny vysledek", pol.getVertex(2).getX() == 0.0);
            assertTrue("Volani getVertex() vraci chybny vysledek", pol.getVertex(2).getY() == 1.0);
            assertTrue("Volani getVertex() vraci chybny vysledek", pol.getVertex(3).getX() == -1.0);
            assertTrue("Volani getVertex() vraci chybny vysledek", pol.getVertex(3).getY() == 0.0);
        } catch(Exception ex) {
            fail("Volani getVertex() zpusobuje vyhozeni neocekavane vyjimky " + ex);
        }

        try {
            pol.getVertex(-1);
            fail("Volani getVertex() se zapornym indexem nevyhazuje pozadovanou vyjimku");
        } catch(IllegalArgumentException ex) {
            // ok
        } catch(Exception ex) {
            fail("Volani getVertex() se zapornym indexem vyhazuje spatnou vyjimku " + ex);
        }
            
        Vertex2D[] ePol = {};
        assertNotNull("getVertices() u prazdneho polygonu vraci null, ma vracet prazdnou kolekci", new CollectionPolygon(ePol).getVertices());
        assertTrue("getVertices() u prazdneho polygonu vraci neprazdnou kolekci vrcholu", new CollectionPolygon(ePol).getVertices().isEmpty());
        assertEquals("getVertices() vraci kolekci se spatnym poctem vrcholu", 3, pol.getVertices().size());
        try {
            pol.getVertices().add(new Vertex2D(0.0, 0.0));
            assertEquals("getVertices() vraci modifikovatelnou kolekci", 3, pol.getVertices().size());
        } catch(UnsupportedOperationException ex) {
            // ok
        }
        
        Vertex2D[] bPol = {new Vertex2D(-1,0), new Vertex2D(-1,0), new Vertex2D(0,1)};
        pol = new CollectionPolygon(bPol);
        assertEquals("CollectionPolygon ma podporovat duplicitni vrcholy", 3, pol.getNumVertices());
        assertTrue("getVertex() vraci spatny vrchol.", pol.getVertex(0).getX() == -1.0);
        assertTrue("getVertex() vraci spatny vrchol.", pol.getVertex(0).getY() ==  0.0);
        assertTrue("getVertex() vraci spatny vrchol.", pol.getVertex(1).getX() == -1.0);
        assertTrue("getVertex() vraci spatny vrchol.", pol.getVertex(1).getY() ==  0.0);
        assertTrue("getVertex() vraci spatny vrchol.", pol.getVertex(2).getX() ==  0.0);
        assertTrue("getVertex() vraci spatny vrchol.", pol.getVertex(2).getY() ==  1.0);
        assertTrue("getVertex() vraci spatny vrchol.", pol.getVertex(3).getX() == -1.0);
        assertTrue("getVertex() vraci spatny vrchol.", pol.getVertex(3).getY() ==  0.0);
        
        CollectionPolygon inv = new CollectionPolygon(new Vertex2D[] {new Vertex2D(-1,0), new Vertex2D(0,-1), new Vertex2D(0,1)}).invert();
        assertEquals("CollectionPolygon ma podporovat duplicitni vrcholy", 3, inv.getNumVertices());
        assertTrue("getVertex() vraci spatny vrchol.", inv.getVertex(0).getX() ==  0.0);
        assertTrue("getVertex() vraci spatny vrchol.", inv.getVertex(0).getY() ==  1.0);
        assertTrue("getVertex() vraci spatny vrchol.", inv.getVertex(1).getX() ==  0.0);
        assertTrue("getVertex() vraci spatny vrchol.", inv.getVertex(1).getY() == -1.0);
        assertTrue("getVertex() vraci spatny vrchol.", inv.getVertex(2).getX() == -1.0);
        assertTrue("getVertex() vraci spatny vrchol.", inv.getVertex(2).getY() ==  0.0);
        assertTrue("getVertex() vraci spatny vrchol.", inv.getVertex(3).getX() ==  0.0);
        assertTrue("getVertex() vraci spatny vrchol.", inv.getVertex(3).getY() ==  1.0);
    }

    @Test 
    public void task03() {
        BasicRulesTester.testAttributes(Color.class);
        try {
            assertEquals("Chybi cervena barva", Color.RED, Color.valueOf("RED"));
            assertEquals("Chybi cervena barva", Color.GREEN, Color.valueOf("GREEN"));
            assertEquals("Chybi cervena barva", Color.BLUE, Color.valueOf("BLUE"));
        } catch(IllegalArgumentException ex) {
            fail("Nadefineujte zakladni barvy (cervena, modra, zelena, apod.) jako vyctovy typ");
        }
        assertTrue("Chybna dedicnost", (new GeneralRegularPolygon(new Vertex2D(0,0), 8, 10).getColor() instanceof Color));
    }
    
}
