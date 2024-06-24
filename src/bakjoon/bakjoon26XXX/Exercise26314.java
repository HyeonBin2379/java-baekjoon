package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise26314 {
    private static final Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String input = br.readLine();
            int len = input.length();
            int vowelCnt = (int) input.chars().filter(value -> vowels.contains((char)value)).count();
            System.out.println(input);
            System.out.println(vowelCnt > len-vowelCnt ? 1 : 0);
        }
    }
}
