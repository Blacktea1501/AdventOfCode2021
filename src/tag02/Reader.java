package tag02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    private ArrayList<Double> doubles = new ArrayList<Double>();

    public ArrayList<Double> getDoubles() {
        return doubles;
    }

    public Reader(String data) {
        //System.out.println("Reading data...");
        readFile(data);
    }

    private void readFile(String data) {
        File myFile = new File(data);

        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {

            String line;
            String[] numbers;

            while ((line = reader.readLine()) != null) {
                numbers = line.split("([a-z])+ ([0-9])\n");
                for (String token : numbers) {
                    doubles.add(Double.parseDouble(token));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

