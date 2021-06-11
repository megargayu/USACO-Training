/*
ID: megarga1
LANG: JAVA
TASK: dualpal
*/

import java.io.*;

public class dualpal {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("dualpal.in"));
        String[] line1 = input.readLine().split(" ");
        int N = Integer.parseInt(line1[0]), S = Integer.parseInt(line1[1]);
        input.close();

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        int found = 0;
        for (int i = S + 1; found < N; i++) {
            int basesFound = isPalindrome(String.valueOf(i)) ? 1 : 0; // Do base 10
            for (int base = 2; base < 10; base++) {
                if (isPalindrome(toBase(i, base))) basesFound++;
                if (basesFound == 2) {
                    out.println(i);
                    found++;
                    break;
                }
            }
        }
        out.close();
    }

    private static String toBase(int num, int base) {
        final String numbers = "0123456789ABCDEFGHIJ";

        int quotient = Math.floorDiv(num, base), remainder = num % base;
        StringBuilder result = new StringBuilder();
        while (quotient > 0) {
            result.insert(0, numbers.charAt(remainder));
            remainder = quotient % base;
            quotient = Math.floorDiv(quotient, base);
        }
        result.insert(0, numbers.charAt(remainder));
        return result.toString();
    }

    private static boolean isPalindrome(String s) {
        int i = -1, j = s.length();
        while (i++ < j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }
}
