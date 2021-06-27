/*
ID: megarga1
LANG: JAVA
TASK: runround
*/

import java.io.*;

public class runround {
    private static int[] digits;
    private static int[] currDigits;
    private static boolean[] taken;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("runround.in"));
        char[] line1 = input.readLine().toCharArray();
        digits = new int[line1.length];
        for (int i = 0; i < line1.length; i++)
            digits[i] = Character.getNumericValue(line1[i]);
        input.close();

        for (int i = digits.length; i <= 9; i++) {
            currDigits = new int[i];
            taken = new boolean[9];
            recurse(0, i);
        }
    }

    private static void recurse(int index, int length) throws IOException {
        if (index == length) {
            if (isRunaround(length) && isGreaterThan(length)) finish(length);
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (taken[i]) continue;
            currDigits[index] = i + 1;
            taken[i] = true;
            recurse(index + 1, length);
            taken[i] = false;
        }
    }

    private static void finish(int length) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        for (int i = 0; i < length; i++) out.print(currDigits[i]);
        out.println();
        out.close();

        System.exit(0);
    }

    private static boolean isGreaterThan(int length) {
        if (length > digits.length) return true;
        for (int i = 0; i < length; i++) {
            if      (currDigits[i] > digits[i]) return true;
            else if (currDigits[i] < digits[i]) return false;
        }
        return false;
    }

    private static boolean isRunaround(int length) {
        boolean[] seen = new boolean[length];
        int pointer = 0;
        for (int i = 0; i < length; i++) {
            pointer = (pointer + currDigits[pointer]) % length;
            if (seen[pointer]) return false;
            seen[pointer] = true;
        }
        return pointer == 0;
    }
}
