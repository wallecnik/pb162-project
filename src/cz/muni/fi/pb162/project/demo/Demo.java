package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Triangle;


/**
 * Program itself
 * 
 * @author Wallecnik
 * @version 7.10.2014
 */
public class Demo {
    
    public static void main(String[] args){
        
        Vertex2D vertA = new Vertex2D(-100, 0);
        
        Vertex2D vertB = new Vertex2D(0, 100);
        
        Vertex2D vertC = new Vertex2D(100, -100);
        
        Triangle triangle = new Triangle(vertA, vertB, vertC);
        
        System.out.println(triangle);
        
    }
    
}
