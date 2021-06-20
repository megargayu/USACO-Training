/*
ID: megarga1
LANG: JAVA
TASK: hamming
*/

import java.io.*;

public class hamming {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("hamming.in"));
        String[] line = input.readLine().split(" ");
        int N = Integer.parseInt(line[0]), B = Integer.parseInt(line[1]), D = Integer.parseInt(line[2]);
        input.close();

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));

        int[] result = new int[N]; // all previous binary numbers
        int lastIndex = 0, maxBin = 1 << B; // 2 to the power of B
        binaryLoop:
        for (int bin = 0; bin < maxBin && lastIndex < N; bin++) { // Loop through every possible binary number
            // check if number is valid with all other numbers in result
            for (int i = 0; i < lastIndex; i++)
                if (hammingDistance(result[i], bin) < D) // invalid (not far enough hamming distance from a number)
                    continue binaryLoop;

            // the number is valid, store it for later use
            result[lastIndex] = bin;
            lastIndex++;

            // print out solution
            if (lastIndex % 10 == 0 || lastIndex == N) {
                out.println(bin);
            } else {
                out.print(bin);
                out.print(' ');
            }
        }
        out.close();
    }

    private static int hammingDistance(int a, int b) {
        /* Find the hamming distance between a and b (in binary). XOR truth table shows:
            ^ | 0  1
           ---+------
            0 | 0  1
            1 | 1  0
           Meaning that all differences between a and b's bits will become into 1, and all similarities
           become 0. After that, call Integer.bitCount on that value to count the number of 1's in that
           XOR, which is the hamming distance!
         */
        return Integer.bitCount(a ^ b);
    }
}
