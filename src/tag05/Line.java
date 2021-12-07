package tag05;

import java.awt.*;

public class Line {
    double xStart;
    double yStart;
    double xEnd;
    double yEnd;
    double length;

    public Line(double xStart, double yStart, double xEnd, double yEnd) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.length = Math.sqrt(Math.pow((xStart-xEnd), 2) + Math.pow((yStart-yEnd), 2));
    }

    public boolean crossingLines(Line other){
        if(isHorizontal() && other.isVertical()){
            return Math.min(this.xStart, this.xEnd) < other.xStart && Math.max(this.xStart, this.xEnd) > other.xStart && Math.min(other.yStart, other.yEnd) < this.yStart && Math.max(other.yStart, other.yEnd) > this.yStart;
        }
        else if(isVertical() && other.isHorizontal()){
            return Math.min(other.xStart, other.xEnd) < this.xStart && Math.max(other.xStart, other.xEnd) > this.xStart && Math.min(this.yStart, this.yEnd) < other.yStart && Math.max(this.yStart, this.yEnd)>other.yStart;
        }
        return false;
    }

    public Point getCrossingPoint(Line other) {
        double x = 0;
        double y = 0;
        if (crossingLines(other)) {
            if (isVertical()) {
                x = this.xStart;
            } else {
                x = other.xStart;
            }
            if (isHorizontal()) {
                y = this.yStart;
            } else {
                y = other.yStart;
            }
            return new Point(x, y);
        }
        return new Point(x, y);
    }

    public boolean isVertical(){
        return xStart == xEnd;
    }

    public boolean isHorizontal(){
        return yStart==yEnd;
    }

    public double getxStart() {
        return xStart;
    }

    public double getyStart() {
        return yStart;
    }

    public double getxEnd() {
        return xEnd;
    }

    public double getyEnd() {
        return yEnd;
    }

    public double getLength() {
        return length;
    }
}
