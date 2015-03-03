package cz.muni.fi.pb162.project.geometry;


/**
 * Respresents one point
 * 
 * @author Wallecnik
 * @version 4.12.2014
 */
public class Vertex2D implements Comparable<Vertex2D> {
    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex2D vertex2D = (Vertex2D) o;

        if (Double.compare(vertex2D.x, x) != 0) return false;
        if (Double.compare(vertex2D.y, y) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }


    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * <p/>
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     * <p/>
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     * <p/>
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     * <p/>
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     * <p/>
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param vert the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Vertex2D vert) {
        if (vert == null) throw new NullPointerException();
        if (this.getX() < vert.getX()) return -1;
        if (this.getX() > vert.getX()) return 1;
        if (this.getY() < vert.getY()) return -1;
        if (this.getY() > vert.getY()) return 1;
        return 0;
    }
}