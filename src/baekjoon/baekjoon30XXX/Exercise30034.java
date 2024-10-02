package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Exercise30034 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> deli = new LinkedHashSet<>();
        for (int i = 0; i < 2; i++) {
            int n = Integer.parseInt(br.readLine());
            Arrays.stream(br.readLine().split(" ", n)).map(s -> s.charAt(0)).forEach(deli::add);
        }
        int k = Integer.parseInt(br.readLine());
        Arrays.stream(br.readLine().split(" ", k)).map(s -> s.charAt(0)).forEach(deli::remove);

        int len = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        boolean nextLine = false;
        for (int i = 0; i < len; i++) {
            if (!deli.contains(input.charAt(i)) && input.charAt(i) != ' ') {
                sb.append(input.charAt(i));
                nextLine = true;
                continue;
            }
            if (nextLine) {
                sb.append("\n");
                nextLine = false;
            }
        }
        System.out.print(sb);
    }
}
