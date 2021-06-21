/*
ID: megarga1
LANG: JAVA
TASK: preface
*/

import java.io.*;
import java.util.LinkedHashMap;

public class preface {
    // Need to keep order, so LinkedHashMap
    private static final LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>() {{
        put(1, "I");
        put(4, "IV");
        put(5, "V");
        put(9, "IX");
        put(10, "X");
        put(40, "XL");
        put(50, "L");
        put(90, "XC");
        put(100, "C");
        put(400, "CD");
        put(500, "D");
        put(900, "CM");
        put(1000, "M");
    }};

    private static final Integer[] order = map.keySet().toArray(new Integer[0]);

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("preface.in"));
        int N = Integer.parseInt(input.readLine());
        input.close();

        // We start from first to last anyway, so the insertion order will be the correct order.
        LinkedHashMap<Character, Integer> result = new LinkedHashMap<>();
        // Loop through every number from 1 to N
        for (int i = 1; i <= N; i++) {
            int currNum = i;
            // Get roman numeral representation; going from highest to lowest and subtracting from currNum until you
            // can't anymore. This makes sure we don't get IIIII instead of V, by checking V first instead of I.
            for (int j = order.length - 1; j >= 0; j--) {
                int num = order[j];
                while (currNum >= num) {
                    for (char c : map.get(num).toCharArray()) {
                        result.putIfAbsent(c, 0);
                        result.replace(c, result.get(c) + 1);
                    }
                    currNum -= num;
                }
            }
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
        result.forEach((character, integer) -> out.println(character + " " + integer));
        out.close();
    }
}
