package cz.muni.fi.pb162.project.test;

import cz.muni.fi.pb162.project.test.BasicRulesTester;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.ArrayPolygon;
import cz.muni.fi.pb162.project.geometry.SimplePolygon;
import cz.muni.fi.pb162.project.geometry.Triangle;
import static org.junit.Assert.*;
import org.junit.Test;


/**
 *
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 */
public class ProjectTest {
    
    @Test public void task01() {
        BasicRulesTester.testMethodsAndAttributes(SimplePolygon.class);
        
        assertEquals("Trida SimplePolygon by nemela mit zadny atribut", 0, SimplePolygon.class.getDeclaredFields().length);
        
        BasicRulesTester.testAbstractMethod(SimplePolygon.class, "getVertex", int.class);
        BasicRulesTester.testAbstractMethod(SimplePolygon.class, "getNumVertices", (Class<?>[]) null);
        BasicRulesTester.testNonAbstractMethod(SimplePolygon.class, "getArea", (Class<?>[]) null);
        BasicRulesTester.testNonAbstractMethod(SimplePolygon.class, "getWidth", (Class<?>[]) null);
        BasicRulesTester.testNonAbstractMethod(SimplePolygon.class, "getHeight", (Class<?>[]) null);
        BasicRulesTester.testNonAbstractMethod(SimplePolygon.class, "getLength", (Class<?>[]) null);
        BasicRulesTester.testNonAbstractMethod(SimplePolygon.class, "toString", (Class<?>[]) null);

        SimplePolygon pol = new MockPolygon();
        assertTrue("Chybny vypocet vysky polygonu", pol.getHeight() == 1.0);
        assertTrue("Chybny vypocet sirky polygonu", pol.getWidth() == 2.0);
        assertTrue("Chybny vypocet obvodu polygonu", Math.abs(pol.getLength() - 4.82842712474619) < 0.001);
        assertTrue("Chybny vypocet obsahu polygonu", pol.getArea() == 1.0);
        assertEquals("Chybny metoda toString", "Polygon: vertices = [-3.0, -1.0] [-2.0, -2.0] [-1.0, -1.0]", pol.toString());
    }

    @Test public void task02() {
        BasicRulesTester.testMethodsAndAttributes(ArrayPolygon.class);
        BasicRulesTester.testAncestor(SimplePolygon.class, ArrayPolygon.class);
        BasicRulesTester.testNonAbstractMethod(ArrayPolygon.class, "getVertex", int.class);
        BasicRulesTester.testNonAbstractMethod(ArrayPolygon.class, "getNumVertices", (Class<?>[]) null);
        BasicRulesTester.testRedundantMethod(ArrayPolygon.class, "getArea", (Class<?>[]) null);
        BasicRulesTester.testRedundantMethod(ArrayPolygon.class, "getWidth", (Class<?>[]) null);
        BasicRulesTester.testRedundantMethod(ArrayPolygon.class, "getHeight", (Class<?>[]) null);
        BasicRulesTester.testRedundantMethod(ArrayPolygon.class, "getLength", (Class<?>[]) null);
        BasicRulesTester.testRedundantMethod(ArrayPolygon.class, "toString", (Class<?>[]) null);
        
        try {
            new ArrayPolygon(null);
        } catch(NullPointerException ex) {
            // ok
        } catch(IllegalArgumentException ex) {
            // ok
        } catch(Exception ex) {
            fail("Neocekavana vyjimka " + ex + " pri volani konstruktoru ArrayPolygon(null)");
        }
        
        try {
            new ArrayPolygon(new Vertex2D[] {new Vertex2D(-1,0), null, new Vertex2D(1,0)});
        } catch(NullPointerException ex) {
            // ok
        } catch(IllegalArgumentException ex) {
            // ok
        } catch(Exception ex) {
            fail("Neocekavana vyjimka " + ex + " pri volani konstruktoru s null vrcholem");
        }
        
        Vertex2D[] aPol = {new Vertex2D(-1,0), new Vertex2D(0,-1), new Vertex2D(0,1)};
        SimplePolygon pol = new ArrayPolygon(aPol);
        try {
            assertTrue("Volani getVertex() vraci chybny vysledek", pol.getVertex(0).getX() == -1.0);
            assertTrue("Volani getVertex() vraci chybny vysledek", pol.getVertex(0).getY() == 0.0);
            assertTrue("Volani getVertex() vraci chybny vysledek", pol.getVertex(1).getX() == 0.0);
            assertTrue("Volani getVertex() vraci chybny vysledek", pol.getVertex(1).getY() == -1.0);
            assertTrue("Volani getVertex() vraci chybny vysledek", pol.getVertex(2).getX() == 0.0);
            assertTrue("Volani getVertex() vraci chybny vysledek", pol.getVertex(2).getY() == 1.0);
            assertTrue("Volani getVertex() vraci chybny vysledek", pol.getVertex(3).getX() == -1.0);
            assertTrue("Volani getVertex() vraci chybny vysledek", pol.getVertex(3).getY() == 0.0);
        } catch(IndexOutOfBoundsException ex) {
            fail("Volani getVertex() zpusobuje vyhozeni vyjimky IndexOutOfBoudsException pro korektni indexy");
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
            
        aPol[0] = new Vertex2D(2.0, 2.0);
        assertTrue("Konsturktor nekopiruje pole, pouze uklada ukazatel", pol.getVertex(0).getX() == -1.0);
    }

    @Test public void task03() {
        BasicRulesTester.testMethodsAndAttributes(Triangle.class);
        BasicRulesTester.testAncestor(ArrayPolygon.class, Triangle.class);
        
        BasicRulesTester.testNonAbstractMethod(Triangle.class, "isEquilateral", (Class<?>[]) null);
        
        BasicRulesTester.testRedundantMethod(Triangle.class, "toString", (Class<?>[]) null);
        BasicRulesTester.testRedundantMethod(Triangle.class, "getArea", (Class<?>[]) null);
        BasicRulesTester.testRedundantMethod(Triangle.class, "getWidth", (Class<?>[]) null);
        BasicRulesTester.testRedundantMethod(Triangle.class, "getHeight", (Class<?>[]) null);
        BasicRulesTester.testRedundantMethod(Triangle.class, "getLength", (Class<?>[]) null);
        BasicRulesTester.testRedundantMethod(Triangle.class, "getVertexA", (Class<?>[]) null);
        BasicRulesTester.testRedundantMethod(Triangle.class, "getVertexB", (Class<?>[]) null);
        BasicRulesTester.testRedundantMethod(Triangle.class, "getVertexC", (Class<?>[]) null);
        
        Triangle tri = new Triangle(new Vertex2D(-1,0), new Vertex2D(0,-1), new Vertex2D(0,1));
        assertTrue("Chybny konstruktor", tri.getVertex(0).getX() == -1.0);
        
        assertEquals("Chybna metoda toString()", "Polygon: vertices = [-1.0, 0.0] [0.0, -1.0] [0.0, 1.0]", tri.toString());
        assertTrue("getArea() dava spatny vysledek", Math.abs(tri.getArea() - 1.0) < 0.001);
    }
    
    private class MockPolygon extends SimplePolygon {
        
        private Vertex2D[] vert = {
            new Vertex2D(-3,-1),
            new Vertex2D(-2,-2),
            new Vertex2D(-1,-1)
        };

        @Override
        public Vertex2D getVertex(int index) {
            return vert[index%vert.length];
        }

        @Override
        public int getNumVertices() {
            return vert.length;
        }        
    }

}
