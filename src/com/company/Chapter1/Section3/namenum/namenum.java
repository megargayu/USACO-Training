/*
ID: megarga1
LANG: JAVA
TASK: namenum
*/

import java.io.*;
import java.util.*;

public class namenum {
    private static final Character[][] serialToChar = {{}, {}, {'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'},
            {'J', 'K', 'L'}, {'M', 'N', 'O'}, {'P', 'R', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y'}};
    private static final TreeSet<String> result = new TreeSet<>();

    private static int[] num;
    private static HashSet<String> dictionary;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("namenum.in"));
        String line = input.readLine();
        num = new int[line.length()];
        for (int i = 0; i < line.length(); i++) num[i] = Character.getNumericValue(line.charAt(i));
        input.close();

        BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
        dictionary = new HashSet<>();
        while ((line = dict.readLine()) != null) dictionary.add(line);
        dict.close();

        recurse(0, "");

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        result.forEach(out::println);
        if (result.size() == 0) out.println("NONE");
        out.close();
    }

    private static void recurse(int i, String s) {
        if (i == num.length) {
            if (dictionary.contains(s)) result.add(s);
            return;
        }

        for (char c : serialToChar[num[i]])
            recurse(i + 1, s + c);
    }
}
