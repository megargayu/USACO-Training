/*
ID: megarga1
LANG: JAVA
TASK: ride
*/

import java.io.*;

public class ride {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("ride.in"));
        String line1 = input.readLine(), line2 = input.readLine();
        input.close();

        int line1Res = 1, line2Res = 1;
        for (int i = 0; i < line1.length(); i++) line1Res *= line1.charAt(i) - 'A' + 1;
        for (int i = 0; i < line2.length(); i++) line2Res *= line2.charAt(i) - 'A' + 1;

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        out.println((line1Res % 47) == (line2Res % 47) ? "GO" : "STAY");
        out.close();
    }
}
