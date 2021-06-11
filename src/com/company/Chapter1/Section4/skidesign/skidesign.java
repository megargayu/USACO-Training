/*
ID: megarga1
LANG: JAVA
TASK: skidesign
*/

import java.io.*;

public class skidesign {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("skidesign.in"));
        int N = Integer.parseInt(input.readLine());
        int[] hills = new int[N];
        for (int i = 0; i < N; i++) hills[i] = Integer.parseInt(input.readLine());
        input.close();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= 83; i++) {
            int cost = 0, raw;
            for (int j = 0; j < N; j++) {
                if (hills[j] < i) raw = i - hills[j];
                else if (hills[j] > i + 17) raw = hills[j] - (i + 17);
                else raw = 0;
                cost += raw * raw;
            }
            answer = Math.min(answer, cost);
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        out.println(answer);
        out.close();
    }

}
