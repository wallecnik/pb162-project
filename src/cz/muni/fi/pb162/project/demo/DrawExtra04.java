package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.OlympicRings;
import cz.muni.fi.pb162.project.geometry.Square;

/**
 * 
 * Trida umoznujici vykresleni grafickych objektu pozadovanych v ramci nepovinnych ukolu.
 * 
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;
 * @version 2013-09-05
 *
 */

public class DrawExtra04 extends Draw {

    public static void main(String[] args) {
        Square square = new Square(new Vertex2D(0,0), 300);
        OlympicRings or = new OlympicRings(new Vertex2D(0,0), 50);
        
        Draw canvas = new DrawExtra04();
        canvas.paintRegularPolygon(square);
        canvas.paintCircle(or.getBlackRing());
        canvas.paintCircle(or.getBlueRing());
        canvas.paintCircle(or.getRedRing());
        canvas.paintCircle(or.getYellowRing());
        canvas.paintCircle(or.getGreenRing());
        canvas.startPainting();
    }

}
