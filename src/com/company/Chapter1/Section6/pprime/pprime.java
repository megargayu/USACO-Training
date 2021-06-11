/*
ID: megarga1
LANG: JAVA
TASK: pprime
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class pprime {
    private static int maxDigits;
    private static int[] nums;
    private static final HashSet<Integer> answers = new HashSet<>();
    private static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("pprime.in"));
        String[] line1 = input.readLine().split(" ");
        a = Integer.parseInt(line1[0]); b = Integer.parseInt(line1[1]);
        maxDigits = line1[1].length();
        nums = new int[maxDigits / 2 + 1];
        input.close();

        for (int i = 1; i <= 9; i += 2) {
            nums[0] = i;
            recurse(1);
        }

        if (a < 11 && 11 < b) answers.add(11); // 11 is the only "even # palindrome" that's also a prime number

        ArrayList<Integer> sorted = new ArrayList<>(answers);
        Collections.sort(sorted);

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        for (int i : sorted)
            out.println(i);
        out.close();
    }

    private static void recurse(int i) {
        int palindrome = toPalindrome(i);
        if (a <= palindrome && palindrome <= b && isPrime(palindrome))
            answers.add(palindrome);

        if (i == maxDigits / 2 + 1) return;

        for (int d = 0; d <= 9; d++) {
            nums[i] = d;
            recurse(i + 1);
        }
    }

    private static int toPalindrome(int length) {
        int answer = 0, mul = (int) Math.pow(10, length * 2 - 2);
        for (int i = 0; i < length * 2 - 1; i++) {
            int numIndex = i >= length - 1 ? length - (i - length + 2) : i;
            answer += mul * nums[numIndex];
            mul /= 10;
        }
        return answer;
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
