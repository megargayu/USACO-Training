/*
ID: megarga1
LANG: JAVA
TASK: holstein
*/

import java.io.*;

public class holstein {
    private static int V; // Number of vitamins
    private static int G; // Number of feeds
    private static int[] requirements; // Required number of vitamins
    private static int[][] feeds; // Feed values

    private static int[] bestFeeds; // Best feed
    private static int bestNumberOfFeeds; // Best number of feeds

    private static int[] currentFeeds; // Current feeds

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("holstein.in"));
        V = Integer.parseInt(input.readLine());
        requirements = new int[V];
        String[] line2 = input.readLine().split(" ");
        for (int i = 0; i < V; i++) requirements[i] = Integer.parseInt(line2[i]);
        G = Integer.parseInt(input.readLine());
        feeds = new int[G][V];

        for (int i = 0; i < G; i++) {
            String[] line = input.readLine().split(" ");
            for (int j = 0; j < V; j++) feeds[i][j] = Integer.parseInt(line[j]);
        }
        input.close();

        // initialize variables
        bestNumberOfFeeds = G + 1;
        bestFeeds = new int[G];
        currentFeeds = new int[G];

        // recurse!
        recurse(0, 0);

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
        out.print(bestNumberOfFeeds);
        out.print(" ");
        // Loop only until bestNumberOfFeeds (ignore the rest) because those values are old/overflow
        // from previous best solutions which had a greater number of feeds in them
        for (int i = 0; i < bestNumberOfFeeds - 1; i++) {
            out.print(bestFeeds[i] + 1);
            out.print(" ");
        }
        out.println(bestFeeds[bestNumberOfFeeds - 1] + 1);
        out.close();
    }

    private static void recurse(int numberOfFeeds, int startFeed) {
        int fq; // first requirement that has not been completed
        for (fq = 0; fq < V; fq++)
            if (requirements[fq] > 0) break;

        // Has to be better (if it wasn't, this recursion wouldn't happen)
        if (fq == V) {
            bestNumberOfFeeds = numberOfFeeds;
            System.arraycopy(currentFeeds, 0, bestFeeds, 0, bestNumberOfFeeds);
            return;
        }

        // numberOfFeeds + 1 < bestNumberOfFeeds makes sure that the next iteration
        // has to be better than the best iteration so far
        while (startFeed < G && numberOfFeeds + 1 < bestNumberOfFeeds) {
            // "add" all feeds (by subtracting from req - if req < 0, then requirements fulfilled)
            for (int i = 0; i < V; i++)
                requirements[i] -= feeds[startFeed][i];
            // Set current feeds
            currentFeeds[numberOfFeeds] = startFeed;

            // Next recursion
            recurse(numberOfFeeds + 1, startFeed + 1);

            // "subtract" all feeds (by adding to req)
            for (int i = 0; i < V; i++)
                requirements[i] += feeds[startFeed][i];
            // Next starting feed
            startFeed++;
        }
    }
}
