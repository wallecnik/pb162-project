package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.demo.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Solid;
import cz.muni.fi.pb162.project.geometry.Circle;
import cz.muni.fi.pb162.project.geometry.Colored;
import cz.muni.fi.pb162.project.geometry.RegularPolygon;
import cz.muni.fi.pb162.project.geometry.ArrayPolygon;
import cz.muni.fi.pb162.project.geometry.SimplePolygon;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * 
 * Trida umoznujici vykresleni doposud dokoncenych grafickych objektu (bod, kruznice, trojuhelnik).
 * 
 * @author Bc. Pavel Beran (255625)
 * @version 2012-10-19
 *
 */

public class Draw extends JFrame {

    /**
     * Znaci polovinu delky usecky pro vykresleni bodu.
     */
    public static final int VERT_LENGTH = 3;

    protected JPanel panel;
    
    private List<Vertex2D> vertices      = new ArrayList<Vertex2D>();
    private List<Triangle> triangles     = new ArrayList<Triangle>();
    private List<Circle>   circles       = new ArrayList<Circle>();
    private List<RegularPolygon> ngons   = new ArrayList<RegularPolygon>();
    private List<SimplePolygon> polygons = new ArrayList<SimplePolygon>();
    
    private Color vertexColor;
    private Color triangleColor;
    private Color circleColor;
    private Color ngonColor;
    private Color polygonColor;
    
    /**
     * Defaultni konstruktor nastavi defaultni barvy pro telesa. Pozadi bile, body cervene, kruznice modre, trojuhelniky zelene
     */
    public Draw() {
        initialize();
        panel.setBackground(Color.WHITE);
        this.vertexColor = Color.RED;
        this.triangleColor = Color.BLUE;
        this.circleColor = Color.ORANGE;
        this.ngonColor = Color.BLACK;
        this.polygonColor = Color.MAGENTA;
    }
    
    private void initialize() {
        panel = new JPanel();
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Vizualizace obrazců. Autor Pavel Beran (255625).");
        add(panel);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        myPaintAll(panel.getGraphics());
    }
    
    /**
     * Spustenim metody zacne vykreslovani vsech teles v seznamech.
     */
    public void startPainting() {
        paint(this.getGraphics());
    }
    
    /**
     * Metoda pro pridani bodu do seznamu pro vykresleni.
     * Metoda vraci logickou hodnotu v zavislosti na tom zda-li neni bod mimo vykreslovaci prostor.
     * 
     * @param vertex Bod ktery chci vykreslit
     * @return true pokud se bod vykresli, false nikoliv
     */
    public boolean paintVertex(Vertex2D vertex) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int x = width - ((int) Math.rint(halfX - vertex.getX()));
        int y = (int) Math.rint(halfY - vertex.getY());
        
        if (x-VERT_LENGTH < 0 || x+VERT_LENGTH > width || y-VERT_LENGTH < 0 || y+VERT_LENGTH > height) {
            return false;
        }
        vertices.add(vertex);
        return true;
    }

    /**
     * Metoda pro pridani kruznice do seznamu pro vykresleni.
     * Metoda vraci logickou hodnotu v zavislosti na tom zda-li neni kruznice mimo vykreslovaci prostor.
     * 
     * @param circle Kruznice kterou chci vykreslit
     * @return true pokud se kruznice vykresli, false nikoliv
     */
    public boolean paintCircle(Circle circle) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int x = width - ((int) Math.rint(halfX - circle.getCenter().getX()));
        int y = (int) Math.rint(halfY - circle.getCenter().getY());
        int r = (int) circle.getRadius();
        
        if (x-r < 0 || x+r > width || y-r < 0 || y+r > height) {
            return false;
        }
        circles.add(circle);
        return true;
    }
    
    /**
     * Metoda pro pridani trojuhelnika do seznamu pro vykresleni.
     * Metoda vraci logickou hodnotu v zavislosti na tom zda-li neni trojuhelnik mimo vykreslovaci prostor.
     * 
     * @param triangle Trojuhelnik ktery chci vykreslit
     * @return true pokud se trojuhelnik vykresli, false nikoliv
     */
    public boolean paintTriangle(Triangle triangle) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        Vertex2D a = triangle.getVertex(0);
        Vertex2D b = triangle.getVertex(1);
        Vertex2D c = triangle.getVertex(2);
        
        int minX = width - ((int) Math.rint(halfX - Math.min(a.getX(), Math.min(b.getX(), c.getX()))));
        int maxX = width - ((int) Math.rint(halfX - Math.max(a.getX(), Math.max(b.getX(), c.getX()))));
        int minY = (int) Math.rint(halfY - Math.min(a.getY(), Math.min(b.getY(), c.getY())));
        int maxY = (int) Math.rint(halfY - Math.max(a.getY(), Math.max(b.getY(), c.getY())));
        
        if (minX < 0 || maxX > width || minY < 0 || maxY > height) {
            return false;
        }
        triangles.add(triangle);
        return true;
    }
    
    /**
     * Metoda pro pridani polygonu do seznamu pro vykresleni.
     * Metoda vraci logickou hodnotu v zavislosti na tom zda-li neni polygon mimo vykreslovaci prostor.
     * 
     * @param polygon Polygon ktery chci vykreslit
     * @param fill Jestli ma byt polygon vyplneny ci nikoliv
     * @return true pokud se polygon vykresli, false nikoliv
     */
    public boolean paintRegularPolygon(RegularPolygon polygon) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int x = width - ((int) Math.rint(halfX - polygon.getCenter().getX()));
        int y = (int) Math.rint(halfY - polygon.getCenter().getY());
        int r = (int) polygon.getRadius();
        
        if (x-r < 0 || x+r > width || y-r < 0 || y+r > height) {
            return false;
        }
        ngons.add(polygon);
        return true;
    }
    
    /**
     * Metoda pro pridani jednoducheho polygonu do seznamu pro vykresleni.
     * Metoda vraci logickou hodnotu v zavislosti na tom zda-li neni polygon mimo vykreslovaci prostor.
     * 
     * @param pol Polygon, ktery chci vykreslit
     * @return true pokud se polygon vykresli, false nikoliv
     */
    public boolean paintSimplePolygon(SimplePolygon pol) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for (int i = 0; i < pol.getNumVertices(); i++) {
            minX = (int) Math.min(minX, pol.getVertex(i%pol.getNumVertices()).getX());
            maxX = (int) Math.min(maxX, pol.getVertex(i%pol.getNumVertices()).getX());
            minY = (int) Math.min(minY, pol.getVertex(i%pol.getNumVertices()).getY());
            maxY = (int) Math.min(maxY, pol.getVertex(i%pol.getNumVertices()).getY());
        }
        
        minX = width - ((int) Math.rint(halfX - minX));
        maxX = width - ((int) Math.rint(halfX - maxX));
        minY = (int) Math.rint(halfY - minY);
        maxY = (int) Math.rint(halfY - maxY);
        
        if (minX < 0 || maxX > width || minY < 0 || maxY > height) {
            return false;
        }
        
        polygons.add(pol);
        return true;
    }
    
    protected void paintVertex(Graphics g, Vertex2D v) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int x = width - ((int) Math.rint(halfX - v.getX()));
        int y = (int) Math.rint(halfY - v.getY());
        g.setColor(vertexColor);
        g.drawLine(x-VERT_LENGTH, y+VERT_LENGTH, x+VERT_LENGTH, y-VERT_LENGTH);
        g.drawLine(x-VERT_LENGTH, y-VERT_LENGTH, x+VERT_LENGTH, y+VERT_LENGTH);
    }
 
    protected void paintCircle(Graphics g, Circle c) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int r = (int) Math.rint(c.getRadius());
        int x = width - ((int) Math.rint(halfX - c.getCenter().getX()) + r);
        int y = (int) Math.rint(halfY - c.getCenter().getY()) - r;
        int w = (int) Math.rint(c.getRadius() * 2.0);
        int h = (int) Math.rint(c.getRadius() * 2.0);
        setColor(g, c, circleColor);
        g.drawOval(x, y, w, h);

    }
    
    protected void paintTriangle(Graphics g, Triangle tri) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int a1 = width - ((int) Math.rint(halfX - tri.getVertex(0).getX()));
        int a2 = (int) Math.rint(halfY - tri.getVertex(0).getY());
        int b1 = width - ((int) Math.rint(halfX - tri.getVertex(1).getX()));
        int b2 = (int) Math.rint(halfY - tri.getVertex(1).getY());
        int c1 = width - ((int) Math.rint(halfX - tri.getVertex(2).getX()));
        int c2 = (int) Math.rint(halfY - tri.getVertex(2).getY());

        setColor(g, tri, triangleColor);
        Polygon triangle = new Polygon();
        triangle.addPoint(a1, a2);
        triangle.addPoint(b1, b2);
        triangle.addPoint(c1, c2);
        g.drawPolygon(triangle);
    }
    
    protected void paintRegularPolygon(Graphics g, RegularPolygon polygon) {
        if (polygon instanceof Circle) {
            paintCircle(g, (Circle) polygon);
            return;
        }
        
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;

        setColor(g, polygon, ngonColor);
        int[] yVertex = new int[polygon.getNumEdges()];
        int[] xVertex = new int[polygon.getNumEdges()];
        
        for (int i = 0; i < polygon.getNumEdges(); i++) {
            xVertex[i] = (int) ((halfX + polygon.getCenter().getX()) - polygon.getRadius() * Math.cos(i * 2 * Math.PI / polygon.getNumEdges()));
            yVertex[i] = (int) ((halfY - polygon.getCenter().getY()) - polygon.getRadius() * Math.sin(i * 2 * Math.PI / polygon.getNumEdges()));
        }
        
        g.drawPolygon(xVertex, yVertex, polygon.getNumEdges());
    }
    
    protected void paintSimplePolygon(Graphics g, SimplePolygon polygon) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int[] yVertex = new int[polygon.getNumVertices()+1];
        int[] xVertex = new int[polygon.getNumVertices()+1];
        
        for (int i = 0; i <= polygon.getNumVertices(); i++) {
            xVertex[i] = width - ((int) Math.rint(halfX - polygon.getVertex(i%polygon.getNumVertices()).getX()));
            yVertex[i] = (int) Math.rint(halfY - polygon.getVertex(i%polygon.getNumVertices()).getY());
        }
        
        setColor(g, polygon, polygonColor);
        g.drawPolygon(xVertex, yVertex, polygon.getNumVertices()+1);
    }
    
    protected void setColor(Graphics g, Solid obj, Color defaultColor) {
        g.setColor(defaultColor);
        
        if (! (obj instanceof Colored)) return;

        String color = ((Colored)obj).getColor();
        if (color.equalsIgnoreCase("white")) g.setColor(Color.WHITE);
        if (color.equalsIgnoreCase("black")) g.setColor(Color.BLACK);
        if (color.equalsIgnoreCase("blue")) g.setColor(Color.BLUE);
        if (color.equalsIgnoreCase("cyan")) g.setColor(Color.CYAN);
        if (color.equalsIgnoreCase("gray")) g.setColor(Color.GRAY);
        if (color.equalsIgnoreCase("green")) g.setColor(Color.GREEN);
        if (color.equalsIgnoreCase("orange")) g.setColor(Color.ORANGE);
        if (color.equalsIgnoreCase("red")) g.setColor(Color.RED);
        if (color.equalsIgnoreCase("yellow")) g.setColor(Color.YELLOW);
        if (color.equalsIgnoreCase("magenta")) g.setColor(Color.MAGENTA);
    }
    
    protected void paintCross(Graphics g) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        g.setColor(Color.LIGHT_GRAY);
        g.drawLine(0, halfY, width, halfY);
        g.drawLine(halfX, 0, halfX, height);
    }
    
    protected void myPaintAll(Graphics g) {
        paintCross(g);
        for (Vertex2D v : vertices) {
            paintVertex(g, v);
        }
        for (Triangle t : triangles) {
            paintTriangle(g, t);
        }
        for (Circle c : circles) {
            paintCircle(g, c);
        }
        for (RegularPolygon ngon : ngons) {
            paintRegularPolygon(g, ngon);
        }
        for (SimplePolygon pol : polygons) {
            paintSimplePolygon(g, pol);
        }
    }
    
    public static void main(String[] args) {
        Vertex2D[] vert1 = {
            new Vertex2D(-100,-100),
            new Vertex2D( -40,  10),
            new Vertex2D(  50,  20),
            new Vertex2D(  10, -20),
            new Vertex2D(  60, -40)
        };
        SimplePolygon tri = new Triangle(new Vertex2D(-200, -200), new Vertex2D(0, 200), new Vertex2D(200, -200));
        SimplePolygon pol = new ArrayPolygon(vert1);
        Draw canvas = new Draw();
        canvas.paintSimplePolygon(pol);
        canvas.paintSimplePolygon(tri);
        canvas.startPainting();
    }
}

