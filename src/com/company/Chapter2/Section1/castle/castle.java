/*
ID: megarga1
LANG: JAVA
TASK: castle
*/

import java.io.*;
import java.util.ArrayList;

public class castle {
    private static class Cell {
        private enum Wall {
            WEST(1),
            NORTH(2),
            EAST(4),
            SOUTH(8);

            private final int number;
            Wall(int number) {
                this.number = number;
            }

            private char toChar() {
                return this.name().charAt(0);
            }
        }

        // west, north, east, south
        private final boolean[] walls;

        // number of the room this cell is in (DFS)
        private int number = -1;

        private Cell(int number) {
            Wall[] wallValues = Wall.values();
            walls = new boolean[wallValues.length];
            for (int i = wallValues.length - 1; i >= 0; i--) {
                Wall wall = wallValues[i];
                if (number - wall.number >= 0) {
                    walls[wall.ordinal()] = true;
                    number -= wall.number;
                }
            }
        }

        private boolean hasNoWall(Wall wall) {
            return !walls[wall.ordinal()];
        }

        public String toString() {
            int res = 0;
            Wall[] wallValues = Wall.values();
            for (int i = 0; i < wallValues.length; i++)
                res += walls[i] ? wallValues[i].number : 0;
            return res + "[" + number + "]";
        }
    }

    private static Cell[][] castle;
    private static final ArrayList<Integer> roomSizes = new ArrayList<>();
    private static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("castle.in"));
        String[] line1 = input.readLine().split(" ");
        M = Integer.parseInt(line1[0]); N = Integer.parseInt(line1[1]);
        castle = new Cell[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = input.readLine().split(" ");
            for (int j = 0; j < M; j++)
                castle[i][j] = new Cell(Integer.parseInt(line[j]));
        }
        input.close();

        // Initialize writer
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));

        // Run flood-fill
        int number = 0, maxRoomSize = 0;
        for (int y = 0; y < N; y++)
            for (int x = 0; x < M; x++)
                if (castle[y][x].number == -1) {
                    roomSizes.add(1);
                    dfs(x, y, number++);
                    maxRoomSize = Math.max(maxRoomSize, roomSizes.get(number - 1));
                }

        // number = Number of rooms and maxRoomSize = Biggest room size
        out.println(number);
        out.println(maxRoomSize);

        // Try to break North and East walls - if it connects to another room, add together their sizes
        int maxRoomSizeBW = 0, maxX = 1, maxY = 1;
        Cell.Wall maxWall = Cell.Wall.NORTH;
        for (int x = 0; x < M; x++)
            for (int y = N - 1; y >= 0; y--) {
                if (y > 0 && castle[y - 1][x].number != castle[y][x].number) {
                    int totalSize = roomSizes.get(castle[y - 1][x].number) + roomSizes.get(castle[y][x].number);
                    if (totalSize > maxRoomSizeBW) {
                        maxRoomSizeBW = totalSize;
                        maxX = y + 1;
                        maxY = x + 1;
                        maxWall = Cell.Wall.NORTH;
                    }
                }

                if (x + 1 < M && castle[y][x + 1].number != castle[y][x].number) {
                    int totalSize = roomSizes.get(castle[y][x + 1].number) + roomSizes.get(castle[y][x].number);
                    if (totalSize > maxRoomSizeBW) {
                        maxRoomSizeBW = roomSizes.get(castle[y][x + 1].number) + roomSizes.get(castle[y][x].number);
                        maxX = y + 1;
                        maxY = x + 1;
                        maxWall = Cell.Wall.EAST;
                    }
                }
            }
        out.println(maxRoomSizeBW);
        out.println(maxX + " " + maxY + " " + maxWall.toChar());
        out.close();
    }

    private static void dfs(int x, int y, int number) {
        if (castle[y][x].number != -1) return;
        castle[y][x].number = number;

        if (x - 1 >= 0 && castle[y][x - 1].number == -1 && castle[y][x].hasNoWall(Cell.Wall.WEST)) {
            roomSizes.set(number, roomSizes.get(number) + 1);
            dfs(x - 1, y, number);
        }

        if (y + 1 < N && castle[y + 1][x].number == -1 && castle[y][x].hasNoWall(Cell.Wall.SOUTH)) {
            roomSizes.set(number, roomSizes.get(number) + 1);
            dfs(x, y + 1, number);
        }

        if (x + 1 < M && castle[y][x + 1].number == -1 && castle[y][x].hasNoWall(Cell.Wall.EAST)) {
            roomSizes.set(number, roomSizes.get(number) + 1);
            dfs(x + 1, y, number);
        }

        if (y - 1 >= 0 && castle[y - 1][x].number == -1 && castle[y][x].hasNoWall(Cell.Wall.NORTH)) {
            roomSizes.set(number, roomSizes.get(number) + 1);
            dfs(x, y - 1, number);
        }
    }
}
