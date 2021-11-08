package Bordfodboldturnering;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public abstract class Turnering {
    ArrayList<Hold> holdListe = new ArrayList<>();
    abstract void læsHoldData(String s)throws FileNotFoundException;
    abstract void fjernOverskud();
    abstract void opsætKamp(int i);
}

