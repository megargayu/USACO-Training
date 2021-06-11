/*
ID: megarga1
LANG: JAVA
TASK: numtri
*/

import java.io.*;

public class numtri {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("numtri.in"));
        int R = Integer.parseInt(input.readLine());

        int[] lastRow = new int[R];
        lastRow[0] = Integer.parseInt(input.readLine());
        for (int i = 2; i <= R; i++) {
            int[] row = new int[R];
            String[] split = input.readLine().split(" ");
            for (int j = 0; j < i; j++) {
                int above = j > 0 ? Math.max(lastRow[j], lastRow[j - 1]) : lastRow[j];
                row[j] = Integer.parseInt(split[j]) + above;
            }

            lastRow = row;
        }
        input.close();

        int answer = 0;
        for (int i = 0; i < R; i++) answer = Math.max(lastRow[i], answer);

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        out.println(answer);
        out.close();
    }

}
