package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.GeneralRegularPolygon;
import cz.muni.fi.pb162.project.demo.Draw;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * 
 * Trida umoznujici vykresleni grafickych objektu pozadovanych v ramci nepovinnych ukolu.
 * 
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;
 * @version 2013-09-05
 *
 */

public class DrawExtra06 extends Draw {

    public static void main(String[] args) {
        GeneralRegularPolygon oct = new GeneralRegularPolygon(new Vertex2D(0,0), 8, 100);
        Draw canvas = new DrawExtra06();
        Triangle[] tri = oct.triangulate();
        
        for (int i = 0; i < tri.length; i++) {
            canvas.paintTriangle(tri[i]);
        }
        
        canvas.startPainting();
    }
}
