/*
ID: megarga1
LANG: JAVA
TASK: lamps
*/

import java.io.*;
import java.util.TreeSet;

public class lamps {
    private static final int[] masks = {
            63, // button 1: 111111
            42, // button 2: 101010
            21, // button 3: 010101 (10101 b/c leading zero gets cut off)
            36, // button 4: 100100 (3k + 1 = 1, 4, ...)
    };

    private static final TreeSet<Integer> result = new TreeSet<>();

    private static int onMask = 0, knownMask = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("lamps.in"));
        int N = Integer.parseInt(input.readLine()), C = Integer.parseInt(input.readLine());

        String[] line2 = input.readLine().split(" ");
        for (int i = 0; i < line2.length - 1; i++) {
            int shiftBy = (5 - (Integer.parseInt(line2[i]) - 1) % 6);
            onMask |= 1 << shiftBy;
            knownMask |= 1 << shiftBy;
        }

        String[] line3 = input.readLine().split(" ");
        for (int i = 0; i < line3.length - 1; i++) {
            int shiftBy = (5 - (Integer.parseInt(line3[i]) - 1) % 6);
            knownMask |= 1 << shiftBy;
        }
        input.close();

        C = C > 4 ? (C % 2 == 0 ? 4 : 3) : C;
        for (; C >= 0; C -= 2)
            recurse(63, 0, C);

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
        if (result.size() == 0)
            out.println("IMPOSSIBLE");

        for (int i : result) {
            String bits = Integer.toBinaryString(i);

            int j = 0;
            whileLoop:
            while (j < N) {
                // Print leading zeros
                for (int z = bits.length(); z < 6; z++) {
                    if (j >= N) break whileLoop;
                    out.print("0");
                    j++;
                }

                // Print looped bits
                if (j + bits.length() >= N) {
                    out.print(bits.substring(0, N - j));
                    break;
                }
                j += bits.length();
                out.print(bits);
            }

            // Print newline
            out.println();
        }
        out.close();
    }

    private static void recurse(int lamps, int index, int buttonPressesLeft) {
        if (buttonPressesLeft == 0) {
            if ((lamps & knownMask) == onMask)
                result.add(lamps);
            return;
        }

        for (; index < 4; index++)
            recurse(lamps ^ masks[index], index + 1, buttonPressesLeft - 1);
    }
}
