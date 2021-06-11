/*
ID: megarga1
LANG: JAVA
TASK: transform
*/

import java.io.*;

public class transform {
    private static int N;
    private static char[][] endGrid;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("transform.in"));
        N = Integer.parseInt(input.readLine());
        char[][] startGrid = new char[N][N];
        endGrid = new char[N][N];
        for (int i = 0; i < N; i++) startGrid[i] = input.readLine().toCharArray();
        for (int i = 0; i < N; i++) endGrid[i] = input.readLine().toCharArray();
        input.close();

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        if (check(rotate(startGrid)))                      out.println('1');
        else if (check(rotate(rotate(startGrid))))         out.println('2');
        else if (check(rotate(rotate(rotate(startGrid))))) out.println('3');
        else if (check(reflect(startGrid)))                out.println('4');
        else if (combination(startGrid))                   out.println('5');
        else if (check(startGrid))                         out.println('6');
        else                                               out.println('7');
        out.close();
    }

    private static char[][] rotate(char[][] toRotate) {
        char[][] rotated = new char[N][N];
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                rotated[y][N - x - 1] = toRotate[x][y];
        return rotated;
    }

    private static char[][] reflect(char[][] toReflect) {
        char[][] reflected = new char[N][N];
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                reflected[y][N - x - 1] = toReflect[y][x];
        return reflected;
    }

    private static boolean combination(char[][] grid) {
        if (check(reflect(rotate(grid)))) return true;
        if (check(reflect(rotate(rotate(grid))))) return true;
        return check(reflect(rotate(rotate(rotate(grid)))));
    }

    private static boolean check(char[][] grid) {
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                if (grid[y][x] != endGrid[y][x])
                    return false;
        return true;
    }
}
