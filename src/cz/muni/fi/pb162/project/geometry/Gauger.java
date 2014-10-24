package cz.muni.fi.pb162.project.geometry;

/**
 * Class for showing information about geometry objects
 *
 * @author Wallecnik
 * @version 16.10.2014
 */
public class Gauger {

    /**
     * Print out useful information about objects
     *
     * Prints out basic attributes
     * and length or perimeter of this object
     *
     * @param object  any object implementing Measurable interface
     */
    public static void printMeasurement(Measurable object){

        System.out.println(object);
        System.out.println("Length/Perimeter: " + object.getLength());

    }

    /**
     * Print out useful information about objects
     *
     * Prints out basic attributes
     * and length or perimeter of this object
     * and area of this object
     *
     * @param object  any object implementing Solid interface
     */
    public static void printMeasurement(Solid object){

        printMeasurement((Measurable) object);
        System.out.println("Area: " + object.getArea());

    }

}
