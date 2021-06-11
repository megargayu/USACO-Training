/*
ID: megarga1
LANG: JAVA
TASK: sprime
*/

import java.io.*;

public class sprime {
    private static final int[] startNums = {2, 3, 5, 7}, validNums = {1, 3, 7, 9};
    private static PrintWriter out;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("sprime.in"));
        N = Integer.parseInt(input.readLine());
        input.close();

        out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        for (int s : startNums)
            recurse(1, s * (int) Math.pow(10, N - 1));

        out.close();
    }

    private static void recurse(int i, int num) {
        if (!isPrime(num / (int) Math.pow(10, N - i))) return;

        if (i == N) {
            out.println(num);
            return;
        }

        for (int n : validNums)
            recurse(i + 1, num + n * (int) Math.pow(10, N - i - 1));
    }

    private static boolean isPrime(int num) {
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i++)
            if (num % i == 0)
                return false;
        return true;
    }
}
