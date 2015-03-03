package cz.muni.fi.pb162.project.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.LabeledPolygon;


/**
 * Trida umoznujici vykresleni grafickych objektu pozadovanych v ramci nepovinnych ukolu.
 * 
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;
 * @version 2013-09-05
 *
 */

public class DrawExtra09 extends Draw {
    
    private static final String TEST_FILE = "cz/muni/fi/pb162/project/demo/polygon.bin";

    public static void main(String[] args) throws IOException {
        LabeledPolygon pol = new LabeledPolygon();
        pol.addVertex("A", new Vertex2D(-100, -100));
        pol.addVertex("C", new Vertex2D( 100, -100));
        pol.addVertex("D", new Vertex2D( 100,  100));
        pol.addVertex("F", new Vertex2D(-100,  100));
        pol.addVertex("B", new Vertex2D(   0,  -20));
        pol.addVertex("E", new Vertex2D(   0,   20));
        
        FileOutputStream fos = new FileOutputStream(TEST_FILE);
        pol.binaryWrite(fos);
        fos.close();
        
        pol = new LabeledPolygon();
        pol.read(new File(TEST_FILE));
        Draw canvas = new Draw();
        canvas.paintLabeledPolygon(pol);
        canvas.startPainting();
    }
}
