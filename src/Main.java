import javafx.util.Pair;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CsvReader r = null;
        Pair<ArrayList<Department>, ArrayList<Human>> result = r.reader("foreign_names.csv");
        System.out.println();
    }
}