package cz.muni.fi.pb162.project.test;

import cz.muni.fi.pb162.project.test.BasicRulesTester;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Circle;
import cz.muni.fi.pb162.project.geometry.Colored;
import cz.muni.fi.pb162.project.geometry.GeneralRegularPolygon;
import cz.muni.fi.pb162.project.geometry.RegularOctagon;
import cz.muni.fi.pb162.project.geometry.RegularPolygon;
import static org.junit.Assert.*;
import org.junit.Test;


/**
 *
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 */
public class ProjectTest {
    
    @Test public void task01() {
        BasicRulesTester.testMethodsAndAttributes(GeneralRegularPolygon.class);
        
        GeneralRegularPolygon pol = new GeneralRegularPolygon(new Vertex2D(1.0, -1.0), 8, 2.0);
        assertTrue("Implementace rozhrani", pol instanceof RegularPolygon);
        assertTrue("Implementace rozhrani", pol instanceof Colored);
        assertTrue("getCenter()", pol.getCenter().getX() == 1.0 && pol.getCenter().getY() == -1.0);
        assertEquals("getNumEdges()", 8, pol.getNumEdges());
        assertTrue("getEdgeLength()", pol.getEdgeLength() == 2.0);
        assertTrue("getRadius()", Math.abs(pol.getRadius() - 2.613125929752753) < 0.001);
        assertTrue("getArea()", Math.abs(pol.getArea() - 19.31370849898476) < 0.001);
        assertTrue("getWidth()", Math.abs(pol.getWidth() - 5.226251859505506) < 0.001);
        assertTrue("getHeight()", Math.abs(pol.getHeight() - 5.226251859505506) < 0.001);
        assertTrue("getLength()", Math.abs(pol.getLength() - 16.0) < 0.001);
        assertEquals("getColor()", "black", pol.getColor());
        pol.setColor("white");
        assertEquals("setColor()", "white", pol.getColor());
        assertEquals("toString()", "8-gon: center=[1.0, -1.0], edge length=2.0, color=white", pol.toString());
    }

    /*
    @Test public void task02() {
        task = 2;
        
        BasicRulesTester.testMethodsAndAttributes(SquareObsolete.class);
        
        SquareObsolete s = new SquareObsolete();
        
        assertTrue("Rozsireni nadtridy", s instanceof GeneralRegularPolygon);
        assertEquals("Nadbytecne atributy", 0, SquareObsolete.class.getDeclaredFields().length);
        try {
            SquareObsolete.class.getDeclaredMethod("toString");
        } catch(NoSuchMethodException ex) {
            fail("Chybi toString()");
        }
        assertEquals("Nadbytecne metody", 1, SquareObsolete.class.getDeclaredMethods().length);
        assertEquals("toString()", "Square: 1.0x1.0, color=white",  s.toString());
        
        pointsPerTest += 1.0;
    }
     */
    
    @Test public void task02() {
        BasicRulesTester.testMethodsAndAttributes(RegularOctagon.class);
        
        RegularOctagon s = new RegularOctagon(new Vertex2D(1.0, -1.0), 2.0);
        
        assertTrue("Rozsireni nadtridy", s instanceof GeneralRegularPolygon);
        assertEquals("Zbytecne atributy", 0, RegularOctagon.class.getDeclaredFields().length);
        
        if (RegularOctagon.class.getDeclaredMethods().length > 0) { // toString is acceptable
            if (RegularOctagon.class.getDeclaredMethods().length == 1) {
                try {
                    RegularOctagon.class.getDeclaredMethod("toString");
                } catch (NoSuchMethodException ex) {
                    fail("Nadbytecne metody");
                }
            } else {
                fail("Nadbytecne metody");
            }
        }
    }

    @Test public void task03() {
        BasicRulesTester.testMethodsAndAttributes(Circle.class);
        
        Circle s = new Circle();
        
        assertTrue("Rozsireni nadtridy", s instanceof GeneralRegularPolygon);
        assertEquals("Pocet atributu", 1, Circle.class.getDeclaredFields().length);
        try {
            Circle.class.getDeclaredMethod("getRadius");
            Circle.class.getDeclaredMethod("getArea");
            Circle.class.getDeclaredMethod("getLength");
            Circle.class.getDeclaredMethod("toString");
        } catch(NoSuchMethodException ex) {
            fail("Chybi nektera prekryta metoda");
        }
        assertEquals("Ve tride jsou nadbytecne metody", 4, Circle.class.getDeclaredMethods().length);
        //assertEquals("toString()", "Circle: center=[0.0, 0.0], radius=1.0, color=white",  s.toString());
        
        assertEquals("Pocet hran", Integer.MAX_VALUE, s.getNumEdges());
        assertTrue("Delka hran", s.getEdgeLength() == 0.0);
        assertTrue("getHeight()", s.getHeight() == 2.0);
        assertTrue("getLength()", Math.abs(s.getLength() - (Math.PI * 2.0)) < 0.001);
        assertTrue("getArea()", Math.abs(s.getArea() - Math.PI) < 0.001);
    }

    /*
    @Test public void task05() {
        task = 5;
        
        Triangle tri = new Triangle(new Vertex2D(-1,0),new Vertex2D(1,0),new Vertex2D(0,1));
        Method extentMethod = null;
        try {
            extentMethod = Triangle.class.getDeclaredMethod("extent", Boolean.TYPE);
        } catch (NoSuchMethodException ex) {
            fail("Chybi metoda extent");
        }
        
        assertTrue("Viditelnost metody extent", Modifier.isProtected(extentMethod.getModifiers()));
        assertTrue("getWidth", Math.abs(tri.getWidth() - 2.0) < 0.001);
        assertTrue("getHeight", Math.abs(tri.getHeight() - 1.0) < 0.001);
        
        pointsPerTest += 0.5;
    }
     */
}
