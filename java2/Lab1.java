import java.util.Scanner;

class Point2d {
    public double xCoord;
    public double yCoord;
    public Point2d (double x, double y) {
        xCoord = x;
        yCoord = y;
    }
    public Point2d () {
        this(0,0);
    }
    public double getX() {
        return xCoord;
    }
    public double getY() {
        return yCoord;
    }
    public void setX ( double val) {
        xCoord = val;
    }
    public void setY ( double val) {
        yCoord = val;
    }
}

class Point3d extends Point2d{
    private double zCoord;   
    public Point3d (double x, double y, double z) {
        super(x,y);
        zCoord = z;
    }
    public Point3d () {
        super(0,0);
        zCoord = 0;
    }
    public double getZ() {
        return zCoord;
    }
    public void setZ ( double val) {
        zCoord = val;
    }
    public boolean isEqual ( Point3d another){
        if (xCoord == another.getX() && yCoord == another.getY() && zCoord == another.getZ()) {
            return true;
        }
        else {
            return false;
        }
    }
    public double distanceTo ( Point3d another){
        double xComp = Math.pow((xCoord-another.getX()), 2);
        double yComp = Math.pow((yCoord-another.getY()), 2); 
        double zComp = Math.pow((zCoord-another.getZ()), 2);
        return Math.sqrt(xComp + yComp + zComp);
    }
}

public class Lab1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Point 1");
        Point3d a = getInput(sc);
        System.out.println("Point 2");
        Point3d b = getInput(sc);
        System.out.println("Point 3");
        Point3d c = getInput(sc);
        sc.close();
        if (a.equals(b) || b.equals(c) || a.equals(c)) {
            System.out.println("incorrect data");
        }
        else {
            System.out.println(computeArea(a, b, c));
        }
    }
    public static Point3d getInput(Scanner sc) {
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double z = sc.nextDouble();
        return new Point3d(x, y, z);
    }

    public static double computeArea(Point3d a, Point3d b, Point3d c) {
        double ab = a.distanceTo(b);
        double bc = b.distanceTo(c);
        double ac = c.distanceTo(a);
        double p = (ab + bc + ac) / 2;
        return Math.sqrt(p*(p-ab)*(p-bc)*(p-ac));
    }
}