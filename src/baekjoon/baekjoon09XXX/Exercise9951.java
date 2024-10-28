package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9951 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("#")) {
                break;
            }
            Arrays.stream(input.split(" "))
                    .map(s -> s.toLowerCase().replaceAll("[^a-z0-9]", ""))
                    .filter(s -> !s.replaceAll("[0-9]", "").isEmpty() && !s.isEmpty())
                    .sorted()
                    .distinct()
                    .forEach(s -> sb.append(s).append("\n"));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}