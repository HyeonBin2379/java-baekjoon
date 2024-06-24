package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Exercise25801 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> count = new TreeMap<>();
        char[] input = br.readLine().toCharArray();
        for (char c : input) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        if (count.values().stream().allMatch(val -> val % 2 == 1)) {
            System.out.println(1);
        } else if (count.values().stream().allMatch(val -> val % 2 == 0)) {
            System.out.println(0);
        } else {
            System.out.println("0/1");
        }
    }
}
