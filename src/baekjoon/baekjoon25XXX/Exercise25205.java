package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise25205 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> lastLetters = new HashSet<>(List.of('y', 'u', 'i', 'o', 'p', 'h', 'j', 'k', 'l', 'b', 'n', 'm'));
        int len = Integer.parseInt(br.readLine());
        String input = br.readLine();

        if (lastLetters.contains(input.charAt(len-1))) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
