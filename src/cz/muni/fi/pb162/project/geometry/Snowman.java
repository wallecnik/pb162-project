package cz.muni.fi.pb162.project.geometry;

/**
 * Awesome class representing SNOWMAN!!!
 *
 * @author Wallecnik
 * @version 16.10.2014
 */

public class Snowman {

    private static double DEFAULT_FACTOR = 0.8;

    Circle bottomBall;
    Circle middleBall;
    Circle topBall;
    Circle rightHandBall;
    Circle leftHandBall;

    /**
     * Constructor of this snowman
     *
     * @param radius  radius of circle of the bottom ball
     * @param factor  shrinking factor for higher circles
     */
    public Snowman (double radius, double factor){

        //check if the radius is in (0..1>
        if (factor <= 0 || factor > 1)
            factor = DEFAULT_FACTOR;

        //sets every circle of this snowman
        setBottomBall(radius);
        setMiddleBall(radius, factor);
        setTopBall(radius, factor);
        setRightHandBall(radius, factor);
        setLeftHandBall(radius, factor);

    }

    private void setBottomBall (double radius) {

        Vertex2D center;
        center = new Vertex2D(0,0);

        bottomBall = new Circle(center, radius);

    }

    private void setMiddleBall (double radius, double factor) {

        Vertex2D center;
        center = new Vertex2D(0, radius + (radius*factor));

        middleBall = new Circle(center, radius*factor);

    }

    private void setTopBall (double radius, double factor) {

        Vertex2D center;
        center = new Vertex2D(0, radius + (radius*factor) + (radius*factor) + (radius*factor*factor));

        topBall = new Circle(center, radius*factor*factor);

    }

    private void setRightHandBall (double radius, double factor) {

        Vertex2D center;
        center = new Vertex2D((radius*factor) + ((radius*factor) / 2), radius + (radius*factor));

        rightHandBall = new Circle(center, (radius*factor) / 2);

    }

    private void setLeftHandBall (double radius, double factor) {

        Vertex2D center;
        center = new Vertex2D(-((radius*factor) + ((radius*factor) / 2)), radius + (radius*factor));

        leftHandBall = new Circle(center, (radius*factor) / 2);

    }

    public Circle getBottomBall () {
        return bottomBall;
    }

    public Circle getMiddleBall () {
        return middleBall;
    }

    public Circle getTopBall () {
        return topBall;
    }

    public Circle getRightHandBall () {
        return rightHandBall;
    }

    public Circle getLeftHandBall () {
        return leftHandBall;
    }

}
