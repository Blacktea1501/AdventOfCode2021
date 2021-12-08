package tag05;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tag05 {

    public static int solve(List<String> input){
        String[] line,point;List<Point> vent;
        Graph[][] graph = initialize(1000);
        Point x1, x2;
        for(String pipe : input){
            line = pipe.split("->");
            line[0] = line[0].strip();
            line[1]=line[1].strip();
            point = line[0].split(",");
            x1= new Point(Integer.parseInt(point[0]), Integer.parseInt(point[1]));
            point = line[1].split(",");
            x2 = new Point(Integer.parseInt(point[0]), Integer.parseInt(point[1]));
            vent = x1.checkPoints(x2);
            addPoint(graph, vent);
        }
        return getPoints(graph);
    }

    public static void addPoint(Graph[][] graph, List<Point> vent){
        if(!vent.isEmpty()){
            for(Point p : vent){
                graph[(int) p.getX()][(int) p.getY()].setCounter();
            }
        }
    }

    public static int getPoints(Graph[][] graph){
        int sum = 0;
        for (Graph[] row: graph) {
            for(Graph point : row){
                if (point.getCounter()>1){
                    sum +=1;
                }
            }
        }
        return sum;
    }

    public static Graph[][] initialize(int length){
        Graph[][] graphs = new Graph[length][length];
        for (int i = 0; i < graphs.length; i++) {
            for (int j = 0; j < graphs[0].length; j++) {
                graphs[i][j] = new Graph(new Point(i,j));
            }
        }
        return graphs;
    }

    public static Graph[][] printLines(Graph[][] graph){
        for(Graph[] row : graph){
            for (Graph point : row){
                System.out.println(point.getCounter() + ",");
            }
            System.out.println();
        }
        return graph;
    }

    public static void main(String[] args){
        List<String> input = new ArrayList<String>();
        String s="";
        File inputFile = new File("/home/artur/Schreibtisch/AoCInputs/input05.txt");
        Scanner scan;
        try {
            scan = new Scanner(inputFile);
            while(scan.hasNext()) {
                s = scan.nextLine();
                input.add(s);
            }
            System.out.println("input received");
            System.out.println(solve(input));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
