package tag05;



public class Graph {
    private Point point;
    private int counter;

    public Graph(Point point) {
        this.point = point;
        this.counter = 0;
    }

    public Point getPoint() {
        return point;
    }

    public int getCounter() {
        return counter;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setCounter() {
        this.counter += 1;
    }
}
