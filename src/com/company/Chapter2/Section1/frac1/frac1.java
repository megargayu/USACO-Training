/*
ID: megarga1
LANG: JAVA
TASK: frac1
*/

import java.io.*;
import java.util.TreeSet;

public class frac1 {
    private static class Fraction implements Comparable<Fraction> {
        private final int num, den;

        public Fraction(int num, int den) {
            this.num = num;
            this.den = den;
        }

        @Override
        public int compareTo(Fraction o) {
            return Double.compare(num / (double) den, o.num / (double) o.den);
        }

        public String toString() {
            return num + "/" + den;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("frac1.in"));
        int N = Integer.parseInt(input.readLine());
        input.close();

        TreeSet<Fraction> result = new TreeSet<>();
        result.add(new Fraction(0, 1));
        result.add(new Fraction(1, 1));
        for (int den = 1; den <= N; den++)
            for (int num = 1; num < den; num++)
                result.add(new Fraction(num, den));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        for (Fraction fraction : result) out.println(fraction);
        out.close();
    }
}
