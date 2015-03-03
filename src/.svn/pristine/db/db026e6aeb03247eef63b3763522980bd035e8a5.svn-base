package cz.muni.fi.pb162.project.test;

import cz.muni.fi.pb162.project.test.BasicRulesTester;
import java.util.Collection;
import java.util.Comparator;
import cz.muni.fi.pb162.project.geometry.SimplePolygon;
import cz.muni.fi.pb162.project.geometry.LabeledPolygon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.VertexInverseComparator;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 */
public class ProjectTest {
    
    @Test public void task01() {
        //assertTrue("Chybna hlavicka tridy", SimplePolygon.class.isAssignableFrom(LabeledPolygon.class));
        BasicRulesTester.testMethodsAndAttributes(LabeledPolygon.class);
        BasicRulesTester.testNonAbstractMethod(LabeledPolygon.class, "getVertex", int.class);
        BasicRulesTester.testNonAbstractMethod(LabeledPolygon.class, "getVertex", String.class);
        BasicRulesTester.testNonAbstractMethod(LabeledPolygon.class, "getNumVertices", (Class<?>[]) null);
        //BasicRulesTester.testNonAbstractMethod(LabeledPolygon.class, "getLabels", Vertex2D.class);
        BasicRulesTester.testNonAbstractMethod(LabeledPolygon.class, "addVertex", String.class, Vertex2D.class);
        
        LabeledPolygon pol = new LabeledPolygon();
        pol.addVertex("b", new Vertex2D(0,-1));
        pol.addVertex("a", new Vertex2D(-1,0));
        pol.addVertex("c", new Vertex2D(0,1));
        
        assertEquals("Spatne poradi vrcholu", new Vertex2D(-1,0), pol.getVertex(0));
        assertEquals("Spatne poradi vrcholu", new Vertex2D(0,-1), pol.getVertex(1));
        assertEquals("Spatne poradi vrcholu", new Vertex2D(0,1), pol.getVertex(2));
        assertEquals("Spatne poradi vrcholu", new Vertex2D(-1,0), pol.getVertex(3));
        
        try {
            pol.getVertex(-1);
            fail("getVertex(-1) ma vracet IllegalArgumentException");
        } catch(IllegalArgumentException ex) {
            // ok
        } catch(Exception ex) {
            fail("getVertex(-1) ma vracet IllegalArgumentException");
        }
        
        assertEquals("getVertex(String) vraci chybne vrcholy", new Vertex2D(-1,0), pol.getVertex("a"));
        assertEquals("getVertex(String) vraci chybne vrcholy", new Vertex2D(0,-1), pol.getVertex("b"));
        assertEquals("getVertex(String) vraci chybne vrcholy", new Vertex2D(0,1), pol.getVertex("c"));
        
        try {
            pol.getVertex("d");
            fail("getVertex(label) ma vracet vhodnou vyjimku pro neexistujici nazev vrcholu");
        } catch(NullPointerException ex) {
            // ok
        } catch(IllegalArgumentException ex) {
            // ok
        } catch(Exception ex) {
            fail("getVertex(label) ma vracet vhodnou vyjimku pro neexistujici nazev vrcholu");
        }
        
        try {
            pol.getVertex("");
            fail("getVertex(label) ma vracet vhodnou vyjimku pro neexistujici nazev vrcholu");
        } catch(NullPointerException ex) {
            // ok
        } catch(IllegalArgumentException ex) {
            // ok
        } catch(Exception ex) {
            fail("getVertex(label) ma vracet vhodnou vyjimku pro neexistujici nazev vrcholu");
        }        

        try {
            pol.getVertex(null);
            fail("getVertex(null) ma vracet vhodnou vyjimku");
        } catch(NullPointerException ex) {
            // ok
        } catch(IllegalArgumentException ex) {
            // ok
        } catch(Exception ex) {
            fail("getVertex(null) ma vracet vhodnou vyjimku");
        }
                
        pol.addVertex("d", new Vertex2D(-1,1));
        assertEquals("addVertex() nepridalo novy vrchol", 4, pol.getNumVertices());
        assertEquals("addVertex() nepridalo novy vrchol na konec polygonu", new Vertex2D(-1,1) , pol.getVertex(3));
        pol.addVertex("d", new Vertex2D(-1,2));
        assertEquals("addVertex() nevymenilo vrhol za novy", new Vertex2D(-1,2) , pol.getVertex(3));
        pol.addVertex("e", new Vertex2D(-1,2));
        assertEquals("addVertex() nepridalo vrchol se stejnymi souradnicemi", new Vertex2D(-1,2), pol.getVertex(4));
        
        
        try {
            pol.addVertex("d", null);
            fail("addVertex(\"d\", null) nevyhodilo vhodnou vyjimku");
        } catch(NullPointerException ex) {
            // ok
        } catch(IllegalArgumentException ex) {
            // ok
        } catch(Exception ex) {
            fail("addVertex(\"d\", null) vyhodilo nevhodnou vyjimku");
        }
        
        try {
            pol.addVertex(null, new Vertex2D(-1,2));
            fail("addVertex(null, vert) nevyhodilo vhodnou vyjimku");
        } catch(NullPointerException ex) {
            // ok
        } catch(IllegalArgumentException ex) {
            // ok
        } catch(Exception ex) {
            fail("addVertex(null, vert) vyhodilo nevhodnou vyjimku");
        }
        
        Collection<String> labels = pol.getLabels();
        try {
            labels.add("aaa");
            fail("getLabels() vraci modifikovatelnou kolekci");
        } catch(UnsupportedOperationException ex) {
            // ok
        }
        
        int i = 0;
        for (String label : labels) {
            if (i == 0 && !label.equalsIgnoreCase("a")) fail("getLabels() vraci nazvy vrcholu ve spatnem poradi");
            if (i == 1 && !label.equalsIgnoreCase("b")) fail("getLabels() vraci nazvy vrcholu ve spatnem poradi");
            if (i == 2 && !label.equalsIgnoreCase("c")) fail("getLabels() vraci nazvy vrcholu ve spatnem poradi");
            i++;
        }

        /*
        Collection<String> labels = pol.getLabels(new Vertex2D(-1,0));
        assertEquals("getLabels() vraci spatne nazvy vrcholu", 1, labels.size());
        for (String ll: labels) {
            assertEquals("getLabels() vraci spatne nazvy vrcholu", "a", ll);
        }
        
        labels = pol.getLabels(new Vertex2D(-1,2));
        assertEquals("getLabels() vraci spatne nazvy vrcholu", 2, labels.size());
        for (String ll: labels) {
            assertTrue("getLabels() vraci spatne nazvy vrcholu", ll.equals("d") || ll.equals("e"));
        }
        
        labels = pol.getLabels(new Vertex2D(4,2));
        assertNotNull("getLabels() nevraci prazdnou kolekci pro neexistujici vrchol", labels);
        assertTrue("getLabels() nevraci prazdnou kolekci pro neexistujici vrchol", labels.isEmpty());
        
        labels = pol.getLabels(null);
        assertNotNull("getLabels() nevraci prazdnou kolekci pro neexistujici vrchol", labels);
        assertTrue("getLabels() nevraci prazdnou kolekci pro neexistujici vrchol", labels.isEmpty());
        */
    }

    @Test public void task02() {
        assertTrue("Chybna hlavicka tridy", Comparable.class.isAssignableFrom(Vertex2D.class));
        BasicRulesTester.testNonAbstractMethod(Vertex2D.class, "compareTo", Vertex2D.class);
        
        Vertex2D v1 = new Vertex2D(0.03, -0.03);
        Vertex2D v2 = new Vertex2D(0.03, -0.03);
        Vertex2D v3 = new Vertex2D(0.07, -0.03);
        Vertex2D v4 = new Vertex2D(0.03, -0.01);
        
        assertTrue("Spatna implementace usporadani", v1.compareTo(v1) == 0);
        assertTrue("Spatna implementace usporadani", v1.compareTo(v2) == 0);
        assertTrue("Spatna implementace usporadani", v1.compareTo(v3) < 0);
        assertTrue("Spatna implementace usporadani", v3.compareTo(v1) > 0);
        assertTrue("Spatna implementace usporadani", v1.compareTo(v4) < 0);
        assertTrue("Spatna implementace usporadani", v4.compareTo(v1) > 0);
    }

    @Test public void task03() {
        assertTrue("Chybna hlavicka tridy", Comparator.class.isAssignableFrom(VertexInverseComparator.class));
        BasicRulesTester.testMethodsAndAttributes(VertexInverseComparator.class);
        BasicRulesTester.testNonAbstractMethod(VertexInverseComparator.class, "compare", Vertex2D.class, Vertex2D.class);
        
        VertexInverseComparator comp = new VertexInverseComparator();
        Vertex2D v1 = new Vertex2D(0.03, -0.03);
        Vertex2D v2 = new Vertex2D(0.03, -0.03);
        Vertex2D v3 = new Vertex2D(0.07, -0.03);
        Vertex2D v4 = new Vertex2D(0.03, -0.01);
        
        assertTrue("Spatna implementace komparatoru", comp.compare(v1, v1) == 0);
        assertTrue("Spatna implementace komparatoru", comp.compare(v1, v2) == 0);
        assertTrue("Spatna implementace komparatoru", comp.compare(v2, v1) == 0);
        assertTrue("Spatna implementace komparatoru", comp.compare(v1, v3) > 0);
        assertTrue("Spatna implementace komparatoru", comp.compare(v3, v1) < 0);
        assertTrue("Spatna implementace komparatoru", comp.compare(v1, v4) > 0);
        assertTrue("Spatna implementace komparatoru", comp.compare(v4, v1) < 0);
    }
    
    @Test public void task04() {
        BasicRulesTester.testNonAbstractMethod(LabeledPolygon.class, "getSortedVertices", (Class<?>[]) null);
        BasicRulesTester.testNonAbstractMethod(LabeledPolygon.class, "getSortedVertices", Comparator.class);
        
        LabeledPolygon pol = new LabeledPolygon();
        pol.addVertex("b", new Vertex2D(0,-1));
        pol.addVertex("a", new Vertex2D(-1,0));
        pol.addVertex("c", new Vertex2D(0,1));
        pol.addVertex("d", new Vertex2D(-1,2));
        pol.addVertex("e", new Vertex2D(-1,2));
        
        assertEquals("getSortedVertices() vraci spatny pocet vrcholu", 4, pol.getSortedVertices().size());
        int i = 0;
        for (Vertex2D v: pol.getSortedVertices()) {
            switch (i++) {
                case 0: 
                    assertEquals("Chyba v getSortedVertices() - spatne poradi", new Vertex2D(-1,0), v);
                    break;
                case 1: 
                    assertEquals("Chyba v getSortedVertices() - spatne poradi", new Vertex2D(-1,2), v);
                    break;
                case 2: 
                    assertEquals("Chyba v getSortedVertices() - spatne poradi", new Vertex2D(0,-1), v);
                    break;
                case 3: 
                    assertEquals("Chyba v getSortedVertices() - spatne poradi", new Vertex2D(0,1), v);
                    break;
                default:
                    fail("CHYBA V TESTU!");
            }
        }

        assertEquals("getSortedVertices(komparator) vraci spatny pocet vrcholu", 
                4, pol.getSortedVertices(new VertexInverseComparator()).size());
        i = 0;
        for (Vertex2D v: pol.getSortedVertices(new VertexInverseComparator())) {
            switch (i++) {
                case 0: 
                    assertEquals("Chyba v getSortedVertices() - spatne poradi", new Vertex2D(0,1), v);
                    break;
                case 1: 
                    assertEquals("Chyba v getSortedVertices() - spatne poradi", new Vertex2D(0,-1), v);
                    break;
                case 2: 
                    assertEquals("Chyba v getSortedVertices() - spatne poradi", new Vertex2D(-1,2), v);
                    break;
                case 3: 
                    assertEquals("Chyba v getSortedVertices() - spatne poradi", new Vertex2D(-1,0), v);
                    break;
                default:
                    fail("CHYBA V TESTU!");
            }
        }
    }
    
}
