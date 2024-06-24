package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Exercise26004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> letterCnt = new TreeMap<>();
        Set<Character> hiarc = new HashSet<>(List.of('H', 'I', 'A', 'R', 'C'));

        int len = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        for (Character letter : hiarc) {
            letterCnt.put(letter, 0);
        }
        for (int i = 0; i < len; i++) {
            if (letterCnt.containsKey(input[i])) {
                letterCnt.put(input[i], letterCnt.get(input[i]) + 1);
            }
        }

        System.out.println(letterCnt.values()
                .stream()
                .min(Comparator.comparingInt(o -> o))
                .get());
    }
}
