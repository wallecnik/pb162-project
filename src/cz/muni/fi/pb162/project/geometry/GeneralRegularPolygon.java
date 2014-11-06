package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing any regular polygon in 2D plain
 *
 * @author Wallecnik
 * @version 23.10.2014
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored {

    private Vertex2D center;
    private int numEdges;
    private double edgeLenght;
    private String color;

    /**
     * Constructor for object of class GeneralRegularPolygon
     *
     * @param center     center of this polygon
     * @param numEdges   number of edges of polygon
     * @param edgeLenght length of the edges of polygon
     */
    public GeneralRegularPolygon (Vertex2D center, int numEdges, double edgeLenght) {

        this.center = center;
        this.numEdges = numEdges;
        this.edgeLenght = edgeLenght;
        this.color = "black";

    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumEdges() {
        return this.numEdges;
    }

    public double getEdgeLength() {
        return this.edgeLenght;
    }

    public Vertex2D getCenter() {
        return this.center;
    }

    /**
     * Returns radius of the minimum bounding circle.
     *
     * @return radius of the minimum bounding circle
     */
    public double getRadius() {

        double radius = edgeLenght / (2 * Math.sin(Math.PI / numEdges));
        return radius;

    }

    /**
     * Return area of a solid object.
     *
     * @return Area
     */
    public double getArea() {

        double area = 0.5 * numEdges * getRadius() * getRadius() * Math.sin(2 * Math.PI / numEdges);
        return area;

    }

    /**
     * Returns the width of the object,
     * i.e. the width of the smallest bounding rectangle.
     *
     * @return object's width
     */
    public double getWidth() {

        return 2 * getRadius();

    }

    /**
     * Returns the height of the object,
     * i.e. the height of the smallest bounding rectangle.
     *
     * @return object's height
     */
    public double getHeight() {

        return 2 * getRadius();

    }

    /**
     * Returns either the length of open 2D geometry (e.g. the length of a polyline)
     * or the perimeter of enclosed 2D object (e.g. the perimeter of a polygon).
     *
     * @return length or perimeter
     */
    public double getLength() {

        return this.numEdges * this.edgeLenght;

    }

    /**
     * Basic information about this polygon
     *
     * @return String with information about this polygon
     */
    public String toString() {

        return getNumEdges() +
                "-gon: center=" +
                center.toString() +
                ", edge length=" +
                getEdgeLength() +
                ", color=" +
                getColor();

    }

}
