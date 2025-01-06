package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Exercise32969 {

    private static final Set<String> dh = Set.of("social", "history", "language", "literacy");
    private static final Set<String> bd = Set.of("bigdata", "public", "society");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (String word : dh) {
            if (input.contains(word)) {
                System.out.println("digital humanities");
                return;
            }
        }
        for (String word : bd) {
            if (input.contains(word)) {
                System.out.println("public bigdata");
                return;
            }
        }
    }
}
