/*
ID: megarga1
LANG: JAVA
TASK: crypt1
*/

import java.io.*;

public class crypt1 {
    private static int answer = 0, N;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("crypt1.in"));
        N = Integer.parseInt(input.readLine());
        numbers = new int[N];
        String line2 = input.readLine();
        for (int i = 0; i < N; i++) numbers[i] = Character.getNumericValue(line2.charAt(i * 2));
        input.close();

        recurse(new int[5], 0);

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        out.println(answer);
        out.close();
    }

    private static void recurse(int[] values, int index) {
        if (index == 5) {
            int a = values[0], b = values[1], c = values[2], d = values[3], e = values[4];
            int p1 = (a * 100 + b * 10 + c) * e, p2 = (a * 100 + b * 10 + c) * d; // abc * e and abc * d
            int result = p1 + 10 * p2;

            // # of digits are valid
            if (p1 < 100 || p1 > 999 || p2 < 100 || p2 > 999)
                return;

            // valid digits
            for (int dig = 0; dig < 3; dig++) {
                if (notContains(p1 % 10) || notContains(p2 % 10)) return;
                p1 /= 10;
                p2 /= 10;
            }

            for (int dig = 0; dig < 4; dig++) {
                if (notContains(result % 10)) return;
                result /= 10;
            }

            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            values[index] = numbers[i];
            recurse(values, index + 1);
        }
    }

    private static boolean notContains(int num) {
        for (int n : numbers)
            if (n == num)
                return false;
        return true;
    }
}
