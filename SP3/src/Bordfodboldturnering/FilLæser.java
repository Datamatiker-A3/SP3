package Bordfodboldturnering;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FilLæser {
    ArrayList<Hold> holdListe = new ArrayList<>();
    public ArrayList<Hold> læsHoldData(String data) throws FileNotFoundException {
        File file = new File(data);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] lineArray = line.split(";");
            int holdIDtmp = Integer.parseInt(lineArray[0]);
            int antalSpilleretmp = Integer.parseInt(lineArray[2]);
            Hold hold = new Hold(holdIDtmp, lineArray[1], antalSpilleretmp);
            holdListe.add(hold);
        }
        return holdListe;
    }
}
