/*
ID: megarga1
LANG: JAVA
TASK: palsquare
*/

import java.io.*;

public class palsquare {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("palsquare.in"));
        int B = Integer.parseInt(input.readLine());
        input.close();

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        for (int N = 1; N <= 300; N++) {
            String powBase = toBase(N * N, B);
            if (isPalindrome(powBase))
                out.println(toBase(N, B) + " " + powBase);
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
