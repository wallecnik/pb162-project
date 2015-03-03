package cz.muni.fi.pb162.project.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.LabeledPolygon;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 */
public class ProjectTest {
    
    private static final String TEST_FILE_OK = "cz/muni/fi/pb162/project/test/pol-ok.txt";
    private static final String TEST_FILE_ERROR = "cz/muni/fi/pb162/project/test/pol-error.txt";
    private static final String TEST_FILE_OUT = "cz/muni/fi/pb162/project/test/pol-out.txt";
    
    @Test public void task01() {
        LabeledPolygon pol = new LabeledPolygon();
        try {
            pol.read(new FileInputStream(TEST_FILE_OK));
            assertEquals("Chybne nactene vrcholy", 5, pol.getNumVertices());
            assertEquals("Chybne nactene vrcholy", new Vertex2D(-1,0), pol.getVertex(0));
            assertEquals("Chybne nactene vrcholy", new Vertex2D(0,-1), pol.getVertex(1));
            assertEquals("Chybne nactene vrcholy", new Vertex2D(0,1), pol.getVertex(2));
            assertEquals("Chybne nactene vrcholy", new Vertex2D(-1,2), pol.getVertex(3));
            assertEquals("Chybne nactene vrcholy", new Vertex2D(-1,2), pol.getVertex(4));
            assertEquals("Chybne nactene vrcholy", new Vertex2D(-1,0), pol.getVertex("vrchol a"));
        } catch (IOException ex) {
            fail("read(InputStream) vyhodila IOException pri nacitani bezchybneho souboru: " + ex);
        }
        
        try {
            pol.read(new FileInputStream(TEST_FILE_ERROR));
            fail("read(InputStream) neselhalo, prestoze jsou na vstupu chyby");
        } catch (IOException ex) { // ok
            assertEquals("read(InputStream) neselhalo atomicky", 5, pol.getNumVertices());
            assertEquals("read(InputStream) neselhalo atomicky", new Vertex2D(-1,0), pol.getVertex(0));
            assertEquals("read(InputStream) neselhalo atomicky", new Vertex2D(0,-1), pol.getVertex(1));
            assertEquals("read(InputStream) neselhalo atomicky", new Vertex2D(0,1), pol.getVertex(2));
            assertEquals("read(InputStream) neselhalo atomicky", new Vertex2D(-1,2), pol.getVertex(3));
            assertEquals("read(InputStream) neselhalo atomicky", new Vertex2D(-1,2), pol.getVertex(4));
        } catch (Exception ex) {
            fail("read(InputStream) selhalo na chybnem vstupu s neocekavanou vyjimkou: " + ex);
        }
    }

    @Test public void task02() {
        LabeledPolygon pol = new LabeledPolygon();
        try {
            pol.read(new FileInputStream(TEST_FILE_OK));
        } catch (IOException ex) {
            fail("read(InputStream) neocekavane vyhodila IOException pri nacitani bezchybneho souboru: " + ex);
        }

        try {
            pol.write(new FileOutputStream(TEST_FILE_OUT));
        } catch (IOException ex) {
            fail("write(OutputStream) neocekavane vyhodila IOException pro zapisu do souboru: " + ex);
        }

        pol = new LabeledPolygon();
        try {
            pol.read(new FileInputStream(TEST_FILE_OUT));
        } catch (IOException ex) {
            fail("Nedokazi zpetne nacist data zapsana pomoci write(OutputStream), zkontrolujte si soubor " + TEST_FILE_OUT + ": " + ex);
        }
    }

    @Test public void task03() {
        System.err.print("Cvicici zkontroluje (ne)zavirani IO proudu a zbytecnou duplikaci kodu");
    }
    
    
}
