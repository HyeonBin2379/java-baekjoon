package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise31306 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> vowel = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        String input = br.readLine().toLowerCase();
        br.close();

        int y_cnt = (int) Arrays.stream(input.split(""))
                .filter(s -> s.equals("y"))
                .count();
        int answer = 0;
        for (int i = 0; i < input.length(); i++) {
            if (vowel.contains(input.charAt(i))) {
                answer++;
            }
        }
        System.out.println(answer + " " + (answer+y_cnt));
    }
}
