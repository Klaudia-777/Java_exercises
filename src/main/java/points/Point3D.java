package points;

import static java.lang.Math.*;

public class Point3D extends Point2D {

    private double z;
    public Point3D(double x,double y,double z){
        super( x, y);
        this.z=z;
    }
    public Point3D(Point2D point2D,double z){
        super(point2D.getX(),point2D.getY());
        this.z=z;
    }

    public double distance(Point3D punkt){
//        return sqrt(pow(super.distance(this),2)+pow(z-punkt.getZ(),2));
        return sqrt(pow(super.distance(this),2)+pow(z-punkt.getZ(),2));

    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
