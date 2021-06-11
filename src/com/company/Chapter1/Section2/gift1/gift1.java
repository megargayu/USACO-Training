/*
ID: megarga1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.LinkedHashMap;

public class gift1 {
    private static final LinkedHashMap<String, Integer> bank = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("gift1.in"));
        int NP = Integer.parseInt(input.readLine());
        for (int i = 0; i < NP; i++) bank.put(input.readLine(), 0);
        for (int i = 0; i < NP; i++) {
            String person = input.readLine();
            String[] money = input.readLine().split(" ");
            int moneyGiven = Integer.parseInt(money[0]), people = Integer.parseInt(money[1]);

            if (moneyGiven == 0 || people == 0) {
                for (int j = 0; j < people; j++) input.readLine(); // put pointer at correct position
                continue;
            }

            bank.put(person, bank.get(person) - moneyGiven + moneyGiven % people);
            for (int j = 0; j < people; j++) {
                String giveTo = input.readLine();
                bank.put(giveTo, (int) Math.floor(bank.get(giveTo) + moneyGiven / (double) people));
            }
        }
        input.close();

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        for (String person : bank.keySet()) out.println(person + " " + bank.get(person));
        out.close();
    }
}
