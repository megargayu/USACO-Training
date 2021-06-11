/*
ID: megarga1
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.TreeSet;

public class milk {
    private static class Farmer implements Comparable<Farmer> {
        private final int unitsAvailable;
        private final int pricePerUnit;

        private Farmer(String[] line) {
            pricePerUnit = Integer.parseInt(line[0]);
            unitsAvailable = Integer.parseInt(line[1]);
        }

        @Override
        public int compareTo(Farmer o) {
            int comp = Integer.compare(this.pricePerUnit, o.pricePerUnit);
            return comp == 0 ? Integer.compare(this.unitsAvailable, o.unitsAvailable) : comp;
        }

        @Override
        public String toString() {
            return pricePerUnit + " " + unitsAvailable;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("milk.in"));
        String[] line1 = input.readLine().split(" ");
        int N = Integer.parseInt(line1[0]), M = Integer.parseInt(line1[1]);
        TreeSet<Farmer> farmers = new TreeSet<>();
        for (int i = 0; i < M; i++) farmers.add(new Farmer(input.readLine().split(" ")));
        input.close();

        int bought = 0, price = 0;
        while (bought < N) {
            Farmer farmer = farmers.pollFirst();
            assert farmer != null;
            int toBuy = (bought + farmer.unitsAvailable > N) ? N - bought : farmer.unitsAvailable;
            bought += toBuy;
            price += toBuy * farmer.pricePerUnit;
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        out.println(price);
        out.close();
    }
}
