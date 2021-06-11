/*
ID: megarga1
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.Arrays;

public class friday {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("friday.in"));
        int N = Integer.parseInt(input.readLine());
        input.close();

        int dayOfWeek = 2;
        int[] answer = new int[7];
        for (int year = 1900; year < 1900 + N; year++)
            for (int month = 0; month < 12; month++)
                for (int day = 0; day < toDays(month, year); day++) {
                    if (day == 12) answer[dayOfWeek]++;
                    dayOfWeek = (dayOfWeek + 1) % 7;
                }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 7; i++) output.append(answer[i]).append(i == 6 ? "" : " ");
        out.println(output);
        out.close();
    }

    private static int toDays(int month, int year) {
        switch (month) {
            case 1: return isLeapYear(year) ? 29 : 28;
            case 8: case 3: case 5: case 10: return 30;
            default: return 31;
        }
    }

    private static boolean isLeapYear(int year) {
        if (year % 100 == 0) return year % 400 == 0;
        return year % 4 == 0;
    }
}
