/*
ID: megarga1
LANG: JAVA
TASK: ariprog
*/

import java.io.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class ariprog {
    private static final HashSet<Integer> bisquares = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("ariprog.in"));
        int N = Integer.parseInt(input.readLine()), M = Integer.parseInt(input.readLine());
        input.close();

        for (int p = 0; p <= M; p++)
            for (int q = 0; q <= M; q++)
                bisquares.add(p * p + q * q);

        // Automatically sort results
        TreeSet<int[]> result = new TreeSet<>(Comparator.comparingInt(o -> ((int[]) o)[1])
                .thenComparing(o -> ((int[]) o)[0]));

        int max = M * M * 2; // Maximum bisquare possible (p = M & q = M, so M^2 + M^2 = M * M * 2)

        // Loop through each possible a value in equation
        for (int a = 0; a <= max; a++) {
            if (!bisquares.contains(a)) continue; // a must be in bisquares (a + 0b = a)

            // Loop through all possible b values (start = 1 as given, end = the leftover
            // space between a and max divided by the maximum arithmetic progression to go up to
            bLoop:
            for (int b = 1; b <= (max - a) / (N - 1); b++) {
                for (int n = 1; n <= N - 1; n++) // Check if all arithmetic progressions of a and b up to N all result
                    if (!bisquares.contains(a + n * b)) // in bisquares
                        continue bLoop;

                // a is the start of the arithmetic progression and b is the distance between each one
                result.add(new int[]{a, b});
            }
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        if (result.size() == 0) out.println("NONE");
        else result.forEach(progression -> out.println(progression[0] + " " + progression[1]));
        out.close();
    }
}
