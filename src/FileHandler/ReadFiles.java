package FileHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadFiles {
    public List<Wine> winesFromList = new ArrayList<>();

    public List<Wine> readFiles() {
        try (BufferedReader redWineRead = new BufferedReader(new FileReader("winequality-red.csv"));
             BufferedReader whiteWineRead = new BufferedReader(new FileReader("winequality-white.csv"))) {

            redWineRead.readLine(); //skipper header
            String line; // Tar vare på hver linje som leses

            while ((line = redWineRead.readLine()) != null) {
                String[] k = line.split(";");
                winesFromList.add(new Wine("red", Double.parseDouble(k[10]), Integer.parseInt(k[11]))); //k[] plasseringer i csv filen
            }

            whiteWineRead.readLine(); // skipper header
            while ((line = whiteWineRead.readLine()) != null) {
                String[] k = line.split(";");
                winesFromList.add(new Wine("white", Double.parseDouble(k[10]), Integer.parseInt(k[11])));
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
