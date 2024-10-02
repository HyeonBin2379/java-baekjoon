package baekjoon.baekjoon30XXX;

import java.io.*;
import java.util.*;

public class Exercise30958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        Map<Character, Integer> letter = new LinkedHashMap<>();
        for (int i = 0; i < len; i++) {
            if (input[i] == ' ' || input[i] == '.' || input[i] == ',') {
                continue;
            }
            letter.put(input[i], letter.getOrDefault(input[i], 0)+1);
        }
        List<Integer> count = new ArrayList<>(letter.values());
        count.sort(Collections.reverseOrder());
        System.out.println(count.get(0));
    }
}
