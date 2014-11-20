package cz.muni.fi.pb162.project.geometry;


/**
 * Respresents one point
 * 
 * @author Wallecnik
 * @version 7.10.2014
 */
public class Vertex2D {
    
    /**
     * Two coordinates of the point
     */
    private double x;
    private double y;
    
    /**
     * Construtor creating the vertex
     * 
     * @param x  coordinate x of the vertex
     * @param y  coordinate y of the vertex
     */
    public Vertex2D (double x, double y) {
        
        this.x = x;
        this.y = y;
        
    }
    
    /**
     * Calculates the distance between this and given vertex
     * 
     * @param  vert object of type Vertex2D for the distance calculation
     * @return      distance of the two vertexes
     */
    public double distance (Vertex2D vert) {

        //checks if given vertex exists
        if (vert == null) return -1.0;

        //calculate the distance
        double dist = Math.sqrt( 
            (this.x - vert.x)*(this.x - vert.x) + (this.y - vert.y)*(this.y - vert.y)
        );
        
        return dist;
        
    }
    
    /**
     * Prints the coordinates of the point
     * 
     * @return  coordinates of the point in brackets
     */
    public String toString(){
        
        return "[" + this.x + ", " + this.y + "]";
        
    }

    public double getX() {
        return this.x;
    }
    
    public double getY(){
        return this.y;
    }

    public boolean equals(Vertex2D vert) {

        if (this.x == vert.x && this.y == vert.y) return true;
        return false;

    }

}