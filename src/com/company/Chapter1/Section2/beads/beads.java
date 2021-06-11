/*
ID: megarga1
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.ArrayList;

public class beads {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("beads.in"));
        int N = Integer.parseInt(input.readLine());
        String necklace = input.readLine();
        necklace += necklace + necklace;
        input.close();

        int answer = 0;
        for (int splitOn = N; splitOn < N * 2; splitOn++) {
            int back = 0, front = 0;
            char backC = '\0', frontC = '\0';
            ArrayList<Integer> collected = new ArrayList<>();
            for (int i = splitOn; i >= 0; i--) {
                if (collected.contains(i % N)) break;

                if (backC == '\0' || backC == 'w') backC = necklace.charAt(i);
                else if (!(necklace.charAt(i) == 'w' || backC == necklace.charAt(i))) break;
                back++;
                collected.add(i % N);
            }

            for (int i = splitOn + 1; i < N * 3; i++) {
                if (collected.contains(i % N)) break;

                if (frontC == '\0' || frontC == 'w') frontC = necklace.charAt(i);
                else if (!(necklace.charAt(i) == 'w' || frontC == necklace.charAt(i))) break;
                front++;
                collected.add(i % N);
            }

            answer = Math.max(answer, back + front);
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        out.println(answer);
        out.close();
    }
}
