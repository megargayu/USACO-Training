/*
ID: megarga1
LANG: JAVA
TASK: test
 */

import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("test.in"));
        String[] line1 = input.readLine().split(" ");
        int i1 = Integer.parseInt(line1[0]), i2 = Integer.parseInt(line1[1]);
        input.close();

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        out.println(i1 + i2);
        out.close();
    }
}
