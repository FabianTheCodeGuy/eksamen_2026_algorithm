package FileHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFiles {
    public List<Wine> readFiles() {
        List<Wine> winesFromList = new ArrayList<>();
        Set<Double> uniqueAlcohol = new HashSet<>(); // holder styr på unike alkoholverdier

        try (BufferedReader redWineRead = new BufferedReader(new FileReader("winequality-red.csv"));
             BufferedReader whiteWineRead = new BufferedReader(new FileReader("winequality-white.csv"))) {

            redWineRead.readLine(); // skipper header
            String line; // tar vare på hver linje som leses

            while ((line = redWineRead.readLine()) != null) {
                String[] k = line.split(";");
                double alcohol = Double.parseDouble(k[10]);
                if (uniqueAlcohol.add(alcohol)) { // add() returnerer false hvis verdien allerede finnes
                    winesFromList.add(new Wine("red", alcohol));
                }
            }

            whiteWineRead.readLine();
            while ((line = whiteWineRead.readLine()) != null) {
                String[] k = line.split(";");
                double alcohol = Double.parseDouble(k[10]);
                if (uniqueAlcohol.add(alcohol)) {
                    winesFromList.add(new Wine("white", alcohol));
                }
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