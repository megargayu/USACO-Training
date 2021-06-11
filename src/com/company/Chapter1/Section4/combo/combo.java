/*
ID: megarga1
LANG: JAVA
TASK: combo
*/

import java.io.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class combo {
    private static class Lock {
        private final int a, b, c;

        private Lock(String[] s) {
            this.a = Integer.parseInt(s[0]);
            this.b = Integer.parseInt(s[1]);
            this.c = Integer.parseInt(s[2]);
        }

        private Lock(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Lock lock = (Lock) o;
            return a == lock.a && b == lock.b && c == lock.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }

        @Override
        public String toString() {
            return a + " " + b + " " + c;
        }
    }

    private static final Set<Lock> locks = new HashSet<>();
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("combo.in"));
        N = Integer.parseInt(input.readLine());
        Lock john = new Lock(input.readLine().split(" "));
        Lock master = new Lock(input.readLine().split(" "));
        input.close();

        findLock(john);
        findLock(master);

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        out.println(locks.size());
        out.close();
    }

    private static void findLock(Lock lock) {
        for (int i = -2; i <= 2; i++) {
            int a = Math.floorMod(lock.a + i, N);
            for (int j = -2; j <= 2; j++) {
                int b = Math.floorMod(lock.b + j, N);
                for (int k = -2; k <= 2; k++) {
                    int c = Math.floorMod(lock.c + k, N);
                    locks.add(new Lock(a, b, c));
                }
            }
        }
    }
}
