package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise2789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> cambridge = new HashSet<>(List.of('C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E'));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (!cambridge.contains(input.charAt(i))) {
                sb.append(input.charAt(i));
            }
        }
        System.out.println(sb);
    }
}
