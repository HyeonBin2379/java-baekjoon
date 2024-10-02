package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise25785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        char[] input = br.readLine().toCharArray();

        for (int i = 0; i < input.length-1; i++) {
            if ((vowels.contains(input[i]) && vowels.contains(input[i+1]))
                    || (!vowels.contains(input[i]) && !vowels.contains(input[i+1]))) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
