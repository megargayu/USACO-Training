/*
ID: megarga1
LANG: JAVA
TASK: barn1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class barn1 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("barn1.in"));
        String[] line1 = input.readLine().split(" ");
        int M = Integer.parseInt(line1[0]), C = Integer.parseInt(line1[2]); // don't need S
        ArrayList<Integer> occupied = new ArrayList<>();
        for (int i = 0; i < C; i++)
            occupied.add(Integer.parseInt(input.readLine()));
        input.close();

        Collections.sort(occupied);

        TreeSet<Integer> maxDistanceIndexes = new TreeSet<>();
        for (int i = 0; i < M - 1; i++) {
            int maxDist = 0, maxDistI = 0;
            for (int j = 1; j < occupied.size(); j++)
                if (occupied.get(j) - occupied.get(j - 1) > maxDist && !maxDistanceIndexes.contains(j)) {
                    maxDist = occupied.get(j) - occupied.get(j - 1);
                    maxDistI = j;
                }

            if (maxDist == 0) break;
            maxDistanceIndexes.add(maxDistI);
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        int answer = 0, lastDistI = 0;
        for (Integer distI : maxDistanceIndexes) {
            answer += occupied.get(distI - 1) - occupied.get(lastDistI) + 1;
            lastDistI = distI;
        }
        answer += occupied.get(occupied.size() - 1) - occupied.get(lastDistI) + 1;
        out.println(answer);
        out.close();
    }
}
