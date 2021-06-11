/*
ID: megarga1
LANG: JAVA
TASK: wormhole
*/

import java.io.*;

public class wormhole {
    private static int N;
    private static int[] nextOnRight;
    private static int[] partner;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("wormhole.in"));
        N = Integer.parseInt(input.readLine());
        int[][] wormholes = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            String[] line = input.readLine().split(" ");
            wormholes[i] = new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])};
        }
        input.close();

        nextOnRight = new int[N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++) {
                // Not on same y or not on right
                if (wormholes[i][1] != wormholes[j][1]) continue;
                if (wormholes[j][0] <= wormholes[i][0]) continue;

                if (nextOnRight[i] == 0 ||
                        wormholes[nextOnRight[i]][0] - wormholes[i][0] > wormholes[j][0] - wormholes[i][0])
                    nextOnRight[i] = j;
            }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        partner = new int[N + 1];
        out.println(solve());
        out.close();
    }

    private static int solve() {
        int i, total = 0;
        for (i = 1; i <= N; i++)
            if (partner[i] == 0)
                break;

        if (i > N) return cycle() ? 1 : 0;

        for (int j = i + 1; j <= N; j++) {
            if (partner[j] == 0) {
                partner[i] = j;
                partner[j] = i;
                total += solve();
                partner[i] = partner[j] = 0;
            }
        }

        return total;
    }

    private static boolean cycle() {
        for (int start = 1; start <= N; start++) {
            int pos = start;
            for (int i = 0; i < N; i++)
                pos = nextOnRight[partner[pos]];
            if (pos != 0) return true;
        }
        return false;
    }
}
