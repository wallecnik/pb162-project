package cz.muni.fi.pb162.project.geometry;


/**
 * Represents triangle
 * 
 * @author Wallecnik
 * @version 16.10.2014
 */
public class Triangle implements Solid{

    /**
     * Accepted deviation when comparing
     */
    public static double ACCEPTED_DEVIATION = 0.001;

    /**
     * Three vertexes of the triangle
     */
    private Vertex2D vertexA;
    private Vertex2D vertexB;
    private Vertex2D vertexC;
    
    /**
     * Three smaller triangles inside this big one
     */
    private Triangle subTriangle0 = null;
    private Triangle subTriangle1 = null;
    private Triangle subTriangle2 = null;
    
    /**
     * Constructor for objects of class Triangle
     * 
     * @param vertA  object of type Vertex2D representing vertex a
     * @param vertB  object of type Vertex2D representing vertex b
     * @param vertC  object of type Vertex2D representing vertex c
     */
    public Triangle(Vertex2D vertA, Vertex2D vertB, Vertex2D vertC) {
        
        this.vertexA = vertA;
        this.vertexB = vertB;
        this.vertexC = vertC;
        
    }
    
    /**
     * Constructor for objects of class Triangle
     * 
     * Creates the Sierpinski triangle. The depth of
     * division is given by @param depth
     * 
     * @param vertA  object of type Vertex2D representing vertex a
     * @param vertB  object of type Vertex2D representing vertex b
     * @param vertC  object of type Vertex2D representing vertex c
     * @param depth  depth of recursion division of this triangle
     */
    public Triangle(Vertex2D vertA, Vertex2D vertB, Vertex2D vertC, int depth) {
        
        this(vertA, vertB, vertC);
        this.divide(depth);
        
    }
    
    /**
     * Shows us the coordinates of the apexes
     * 
     * @return  nicely formatted string of coordinates of the three apexes
     */
    public String toString() {

        //checks if any vertex is null
        if (this.vertexA == null || this.vertexB == null || this.vertexC == null)
            return "INVALID TRIANGLE";
            
        return "Triangle: vertices="
        + vertexA.toString() + " "
        + vertexB.toString() + " "
        + vertexC.toString();
        
    }
    
    public Vertex2D getVertexA() {
        return this.vertexA;
    }
    
    public Vertex2D getVertexB() {
        return this.vertexB;
    }
    
    public Vertex2D getVertexC() {
        return this.vertexC;
    }
    
    /**
     * Tells us whether the triangle has been divided into three smaller ones or not
     * 
     * @return  true if yes false if not
     */
    public boolean isDivided() {

        //checks if any triangle is null - not divided
        if ( this.subTriangle0 == null || this.subTriangle1 == null || this.subTriangle2 == null ) {
            return false;
        }
        
        return true;
        
    }
    
    /**
     * Returns smaller triangle inside this big one
     * 
     * @param  i number of the triangle to be returned
     * @return   object representing i-th small triangle
     */
    public Triangle getSubTriangle(int i) {
        
        if( ! isDivided() ) return null;
        
        switch (i) {
            case 0:
                return this.subTriangle0;
            case 1:
                return this.subTriangle1;
            case 2:
                return this.subTriangle2;
        }
        
        return null;
        
    }
    
    /**
     * Divides the triangle into three smaller ones
     * 
     * @return  false if it was already divided, true on success
     */
    public boolean divide() {
        
        if( isDivided() ) return false;

        //calculate the coordinates between each two vertexes of this triangle
        double xBetweenAB = ( this.vertexA.getX() + this.vertexB.getX() ) / 2;
        double yBetweenAB = ( this.vertexA.getY() + this.vertexB.getY() ) / 2;
        double xBetweenAC = ( this.vertexA.getX() + this.vertexC.getX() ) / 2;
        double yBetweenAC = ( this.vertexA.getY() + this.vertexC.getY() ) / 2;
        double xBetweenBC = ( this.vertexB.getX() + this.vertexC.getX() ) / 2;
        double yBetweenBC = ( this.vertexB.getY() + this.vertexC.getY() ) / 2;

        //create vertexes in the middle of each two original ones
        Vertex2D vertexBetweenAB = new Vertex2D(xBetweenAB, yBetweenAB);
        Vertex2D vertexBetweenAC = new Vertex2D(xBetweenAC, yBetweenAC);
        Vertex2D vertexBetweenBC = new Vertex2D(xBetweenBC, yBetweenBC);

        //create smaller triangles as supposed in sierpinski triangle
        this.subTriangle0 = new Triangle(this.vertexA, vertexBetweenAB, vertexBetweenAC);
        this.subTriangle1 = new Triangle(this.vertexB, vertexBetweenAB, vertexBetweenBC);
        this.subTriangle2 = new Triangle(this.vertexC, vertexBetweenAC, vertexBetweenBC);
        
        return true;
        
    }
    
    /**
     * Divides the triangle into Sierpinski triangle
     * 
     * @param  depth how many division is to be done
     * @return       false if given depth is negative, true on success
     */
    public boolean divide(int depth) {

        //check if the given depth is meaningful
        if (depth < 0) return false;

        //end of recursion
        if (depth == 0) return true;

        //dividing this and sub-triangles
        this.divide();
        this.subTriangle0.divide(depth-1);
        this.subTriangle1.divide(depth-1);
        this.subTriangle2.divide(depth-1);
        
        return true;
        
    }
    
    /**
     * Checks whether the triangle is equilateral or not
     * 
     * @return  true if is equilateral, false if not
     */
    public boolean isEquilateral() {

        //distances between each vertexes
        double d1 = this.vertexA.distance(vertexB);
        double d2 = this.vertexB.distance(vertexC);
        double d3 = this.vertexC.distance(vertexA);

        //checks if distance between each two vertexes is the same
        if ( 
            Math.abs(d1-d2) < ACCEPTED_DEVIATION &&
            Math.abs(d2-d3) < ACCEPTED_DEVIATION &&
            Math.abs(d3-d1) < ACCEPTED_DEVIATION
        ) return true;
        
        return false;
        
    }

    /**
     * Returns the width of the object,
     * i.e. the width of the smallest bounding rectangle.
     *
     * @return object's width
     */
    public double getWidth() {

        double mostLeftX;
        double mostRightX;
        double distance;

        //calculate the most left X-coordinate of the three vertexes
        mostLeftX = Math.min(
                this.vertexA.getX(),
                Math.min(this.vertexC.getX(), this.vertexB.getX())
        );

        //calculate the most right X-coordinate of the three vertexes
        mostRightX = Math.max(
                this.vertexA.getX(),
                Math.max(this.vertexC.getX(), this.vertexB.getX())
        );

        distance = Math.abs ( mostLeftX - mostRightX );

        return distance;


    }

    /**
     * Returns the height of the object,
     * i.e. the height of the smallest bounding rectangle.
     *
     * @return object's height
     */
    public double getHeight() {

        double mostLowY;
        double mostTopY;
        double distance;

        //calculate the most low Y-coordinate of the three vertexes
        mostLowY = Math.min(
                this.vertexA.getY(),
                Math.min(this.vertexC.getY(), this.vertexB.getY())
        );

        //calculate the most top Y-coordinate of the three vertexes
        mostTopY = Math.max(
                this.vertexA.getY(),
                Math.max(this.vertexC.getY(), this.vertexB.getY())
        );

        distance = Math.abs(mostLowY-mostTopY);

        return distance;

    }

    /**
     * Returns either the length of open 2D geometry (e.g. the length of a polyline)
     * or the perimeter of enclosed 2D object (e.g. the perimeter of a polygon).
     *
     * @return length or perimeter
     */
    public double getLength() {

        return vertexA.distance(vertexB) + vertexB.distance(vertexC) + vertexC.distance(vertexA);

    }

    /**
     * Return area of a solid object.
     *
     * @return Area
     */
    public double getArea() {

        double perimeter;
        double area;

        perimeter = this.getLength() / 2;

        //calculate the area of this triangle (using Herod equation)
        area = Math.sqrt(
                perimeter *
                (perimeter - vertexA.distance(vertexB)) *
                (perimeter - vertexB.distance(vertexC)) *
                (perimeter - vertexC.distance(vertexA))
        );

        return area;

    }
}
