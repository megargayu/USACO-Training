/*
ID: megarga1
LANG: JAVA
TASK: milk3
*/

import java.io.*;
import java.util.TreeSet;
import java.util.function.Consumer;

public class milk3 {
    private static class State {
        private final int[] s;

        private State(int[] s) {
            this.s = s;
        }

        public State pour(int from, int to) {
            State newState = new State(s.clone());

            int amt = newState.s[from];
            if (newState.s[to] + amt > cap[to])
                amt = cap[to] - newState.s[to];

            newState.s[from] -= amt;
            newState.s[to] += amt;

            return newState;
        }
    }

    private static final TreeSet<Integer> answer = new TreeSet<>();
    private static final boolean[][][] visited = new boolean[21][21][21];
    private static int[] cap;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("milk3.in"));
        String[] line1 = input.readLine().split(" ");
        cap = new int[]{Integer.parseInt(line1[0]), Integer.parseInt(line1[1]), Integer.parseInt(line1[2])};
        input.close();

        dfs(new State(new int[]{0, 0, cap[2]}));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        answer.forEach(new Consumer<Integer>() {
            private int i = 0;

            @Override
            public void accept(Integer integer) {
                out.print(integer);
                if (i < answer.size() - 1) out.print(" ");
                i++;
            }
        });
        out.println();
        out.close();
    }

    private static void dfs(State state) {
        if (visited[state.s[0]][state.s[1]][state.s[2]]) return;
        visited[state.s[0]][state.s[1]][state.s[2]] = true;

        if (state.s[0] == 0) answer.add(state.s[2]);

        for (int from = 0; from < 3; from++)
            for (int to = 0; to < 3; to++)
                dfs(state.pour(from, to));
    }
}
