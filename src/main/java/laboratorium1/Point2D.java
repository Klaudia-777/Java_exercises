package laboratorium1;

import static java.lang.Math.*;

public class Point2D {
    private double x;
    private double y;
    public Point2D(double x,double y){
        this.x=x;
        this.y=y;
    }

    public double distance(Point2D punkt){
        return sqrt(pow(x-punkt.getX(),2)+pow(y-punkt.getY(),2));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
