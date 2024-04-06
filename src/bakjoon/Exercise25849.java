package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Exercise25849 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> letterCnt = new TreeMap<>();
        char[] input = br.readLine().toCharArray();
        for (char c : input) {
            letterCnt.put(c, letterCnt.getOrDefault(c, 0) + 1);
        }

        if (letterCnt.values().stream().allMatch(val -> val % 2 == 1)) {
            System.out.println(1);
        } else if (letterCnt.values().stream().allMatch(val -> val % 2 == 0)) {
            System.out.println(0);
        } else {
            System.out.println(2);
        }
    }
}
