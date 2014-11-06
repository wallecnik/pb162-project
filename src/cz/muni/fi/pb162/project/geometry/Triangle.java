package cz.muni.fi.pb162.project.geometry;


/**
 * Represents triangle
 * 
 * @author Wallecnik
 * @version 16.10.2014
 */
public class Triangle extends ArrayPolygon implements Solid {

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
        super(new Vertex2D[]{vertA, vertB, vertC});
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
        double xBetweenAB = ( this.getVertex(0).getX() + this.getVertex(1).getX() ) / 2;
        double yBetweenAB = ( this.getVertex(0).getY() + this.getVertex(1).getY() ) / 2;
        double xBetweenAC = ( this.getVertex(0).getX() + this.getVertex(2).getX() ) / 2;
        double yBetweenAC = ( this.getVertex(0).getY() + this.getVertex(2).getY() ) / 2;
        double xBetweenBC = ( this.getVertex(1).getX() + this.getVertex(2).getX() ) / 2;
        double yBetweenBC = ( this.getVertex(1).getY() + this.getVertex(2).getY() ) / 2;

        //create vertexes in the middle of each two original ones
        Vertex2D vertexBetweenAB = new Vertex2D(xBetweenAB, yBetweenAB);
        Vertex2D vertexBetweenAC = new Vertex2D(xBetweenAC, yBetweenAC);
        Vertex2D vertexBetweenBC = new Vertex2D(xBetweenBC, yBetweenBC);

        //create smaller triangles as supposed in sierpinski triangle
        this.subTriangle0 = new Triangle(this.getVertex(0), vertexBetweenAB, vertexBetweenAC);
        this.subTriangle1 = new Triangle(this.getVertex(1), vertexBetweenAB, vertexBetweenBC);
        this.subTriangle2 = new Triangle(this.getVertex(2), vertexBetweenAC, vertexBetweenBC);
        
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
        double d1 = this.getVertex(0).distance(getVertex(1));
        double d2 = this.getVertex(1).distance(getVertex(2));
        double d3 = this.getVertex(2).distance(getVertex(0));

        //checks if distance between each two vertexes is the same
        if ( 
            Math.abs(d1-d2) < 0.001 &&
            Math.abs(d2-d3) < 0.001 &&
            Math.abs(d3-d1) < 0.001
        ) return true;
        
        return false;
        
    }

}
