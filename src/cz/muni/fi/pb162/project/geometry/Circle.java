package cz.muni.fi.pb162.project.geometry;


/**
 * Class representing circle in 2D plain
 * 
 * @author Wallecnik
 * @version 23.10.2014
 */
public class Circle extends GeneralRegularPolygon implements RegularPolygon, Colored{

    private double radius;
    
    /**
     * Constructor for objects of class Circle
     * 
     * @param center object of type Vertex2D for center of this circle
     * @param r      double number for radius of this circle
     */
    public Circle (Vertex2D center, double r) {
        
        this(center);
        this.radius = r;
       
    }

    /**
     * Constructor for objects of class Circle
     *
     * Creates circle in the [0,0] center with radius 1
     */
    public Circle () {

        this(new Vertex2D(0,0));
        this.radius = 1.0;

    }

    /**
     * Constructor for object of class GeneralRegularPolygon
     *
     * @param center center of this polygon
     */
    private Circle(Vertex2D center) {

        super(center, Integer.MAX_VALUE, 0);

    }
    
    /**
     * Returns nicely formatted string with center and radius of this circle
     * 
     * @return  string with center and radius of this circle
     */
    @Override
    public String toString () {
        
        return "Circle: center=" + super.getCenter().toString() + ", radius=" + this.radius;
        
    }

    @Override
    public double getRadius() { return this.radius; }


    /**
     * Return area of a solid object.
     *
     * @return Area
     */
    @Override
    public double getArea() {

        return Math.PI * getRadius() * getRadius();

    }

    /**
     * Returns perimeter of this circle
     *
     * @return perimeter of this crcle
     */
    public double getLength() {

        return 2 * Math.PI * getRadius();

    }

}
