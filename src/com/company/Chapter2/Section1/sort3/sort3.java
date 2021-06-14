/*
ID: megarga1
LANG: JAVA
TASK: sort3
*/

import java.io.*;
import java.util.Arrays;

public class sort3 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("sort3.in"));
        int N = Integer.parseInt(input.readLine());
        int[] arr = new int[N];
        int[] count = new int[3];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input.readLine());
            count[arr[i] - 1]++;
        }
        input.close();

        int[] want = new int[N];
        for (int i = 0; i < count[0]; i++) want[i] = 1;
        for (int i = 0; i < count[1]; i++) want[i + count[0]] = 2;
        for (int i = 0; i < count[2]; i++) want[i + count[0] + count[1]] = 3;

        int answer = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (arr[i] != want[i] && arr[j] != want[j] && arr[i] == want[j] && arr[j] == want[i]) {
                    arr[i] = want[i];
                    arr[j] = want[j];
                    answer++;
                }

        int leftover = 0;
        for (int i = 0; i < N; i++)
            if (arr[i] != want[i])
                leftover++;
        answer += leftover / 3 * 2;

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        out.println(answer);
        out.close();
    }
}
