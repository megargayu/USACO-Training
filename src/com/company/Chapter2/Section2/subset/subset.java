/*
ID: megarga1
LANG: JAVA
TASK: subset
*/

import java.io.*;

public class subset {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("subset.in"));
        int N = Integer.parseInt(input.readLine());
        input.close();

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
        // It's impossible to get equal partitions (check if target is odd, so when dividing by 2 it will have .5)
        if (getMaxSum(N) % 2 == 1) {
            out.println(0);
            out.close();
            return;
        }

        long[] prevBucket = new long[getMaxSum(N) + 1];
        long[] nextBucket = new long[getMaxSum(N) + 1];
        prevBucket[0] = 1;
        nextBucket[0] = 1;

        for (int currN = 1; currN <= N; currN++) {
            int maxSum = getMaxSum(currN);
            for (int i = currN; i <= maxSum; i++)
                nextBucket[i] += prevBucket[i - currN];
            // We can copy only the part we have edited into the previous bucket (saving some time)
            System.arraycopy(nextBucket, currN, prevBucket, currN, maxSum - currN + 1);
        }

        out.println(nextBucket[getMaxSum(N) / 2] / 2);
        out.close();
    }

    private static int getMaxSum(int num) {
        return num * (num + 1) / 2;
    }
}
