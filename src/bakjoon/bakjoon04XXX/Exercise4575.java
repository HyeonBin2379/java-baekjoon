package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise4575 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("END")) {
                break;
            }
            List<String> letters = Arrays.stream(input.split("")).filter(s -> !s.equals(" ")).toList();
            Set<String> temp = new HashSet<>(letters);
            if (temp.size() == letters.size()) {
                sb.append(input).append("\n");
            }
        }
        System.out.print(sb);
    }
}
