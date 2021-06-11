/*
ID: megarga1
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.TreeSet;

public class milk2 {
    private static class Time implements Comparable<Time> {
        private final int time;
        private final boolean isStart;

        public Time(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public String toString() {
            return time + (isStart ? "S" : "E");
        }

        @Override
        public int compareTo(Time o) {
            return time == o.time ? (o.isStart ? 1 : -1) : Integer.compare(time, o.time);
        }
    }

    private static final TreeSet<Time> times = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("milk2.in"));
        int N = Integer.parseInt(input.readLine());
        int lastStart = -1, lastEnd = -1;
        for (int i = 0; i < N; i++) {
            String[] line = input.readLine().split(" ");
            int start = Integer.parseInt(line[0]), end = Integer.parseInt(line[1]);
            if (lastStart == -1) { lastStart = start; lastEnd = end; }
            times.add(new Time(start, true));
            times.add(new Time(end, false));
        }
        input.close();

        int currCows = 0;
        int cont = 0, idle = 0;
        for (Time time : times) {
            // If we are starting milking again
            if (currCows == 0 && time.isStart) {
                idle = Math.max(idle, time.time - lastEnd);
                lastStart = time.time;
            }

            if (time.isStart) currCows++;
            else currCows--;

            // If we are ending milking
            if (currCows == 0 && !time.isStart) {
                cont = Math.max(cont, time.time - lastStart);
                lastEnd = time.time;
            }

            if (time.isStart && lastStart == -1) lastStart = time.time;
            if (!time.isStart && lastEnd == -1) lastEnd = time.time;
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        out.println(cont + " " + idle);
        out.close();
    }
}
