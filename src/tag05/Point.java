package tag05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public List<Point> checkPoints(Point other) {
        double min, max;
        List<Point> c = new LinkedList<Point>();
        if (other.getX() == this.x && other.getY() == this.y) {
            c.add(new Point(this.x, this.y));
            return c;
        }
        // bei gleichen x-koordinaten sollen y geprüft werden.
        if (other.getX() == this.x) {
            max = Math.max(other.getY(), this.y);
            min = Math.min(other.getY(), this.y);
            for (double i = min; i <= max; i++) {
                c.add(new Point(this.x, i));
            }
            return c;
        }
        // bei gleichen y-koordinaten sollen x geprüft werden.
        if (other.getY() == this.y) {
            max = Math.max(other.getX(), this.x);
            min = Math.min(other.getX(), this.x);
            for (double i = min; i <= max; i++) {
                c.add(new Point(i, this.y));
            }
            return c;
        }
        if (other.getX() == other.getY() && this.x == this.y) {
            max = Math.max(other.getX(), this.x);
            min = Math.min(other.getX(), this.x);
            for (double i = min; i <= max; i++) {
                c.add(new Point(i, i));
            }
            return c;
        }

        if (other.getX() == this.y && this.x == other.getY()) {
            max = Math.abs(this.y - x);
            for (int i = 0; i <= max; i++) {
                if (this.x > other.getX()) {
                    c.add(new Point(this.x - i, this.y + i));
                } else {
                    c.add(new Point(this.x + i, this.y - i));
                }
            }
            return c;
        }
        double slope = (this.y - other.getY()) / (this.x - other.getX());
        int counter = 0;
        System.out.println(this.toString() + " -> " + other.toString() + " : " + slope);
        max = Math.abs(this.y - this.x);
        Point p1, p2;
        if(slope == 1){
            if (this.x < other.getX()){
                p1 = new Point(this.x, this.y);
                p2 = new Point(other.getX(), other.getY());
            }
            else {
                p1 = new Point(other.getX(), other.getY());
                p2 = new Point(this.x, this.y);
            }
            for (double i = p1.getX(); i <= p2.getX() ; i++) {
                c.add(new Point(i, p1.getY() + counter));
                counter++;
            }
            return c;
        }
        counter = 0;
        if (slope == -1){
            if (this.x > other.getX()){
                p1 = new Point(this.x, this.y);
                p2 = new Point(other.getX(), other.getY());
            }else{
                p2 = new Point(this.x, this.y);
                p1 = new Point(other.getX(), other.getY());
            }
            for (double i = p1.getX(); i >= p2.getX() ; i--) {
                c.add(new Point(i, p1.getY() + counter));
                counter++;
            }
            return c;
        }
        return c;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
