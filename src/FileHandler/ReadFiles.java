package FileHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFiles {
    public List<Wine> readFiles() {
        List<Wine> winesFromList = new ArrayList<>();

        try (BufferedReader redWineRead = new BufferedReader(new FileReader("winequality-red.csv"));
             BufferedReader whiteWineRead = new BufferedReader(new FileReader("winequality-white.csv"))) {

            redWineRead.readLine(); // skipper header
            String line; // tar vare på hver linje som leses

            while ((line = redWineRead.readLine()) != null) {
                String[] k = line.split(";");
                winesFromList.add(new Wine("red", Double.parseDouble(k[10])));
            }

            whiteWineRead.readLine(); // skipper header
            while ((line = whiteWineRead.readLine()) != null) {
                String[] k = line.split(";");
                winesFromList.add(new Wine("white", Double.parseDouble(k[10])));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return winesFromList;
    }

    public List<Wine> shuffleWines(List<Wine> wines) {
        Collections.shuffle(wines); // shuffler listen tilfeldig
        return wines;
    }
}