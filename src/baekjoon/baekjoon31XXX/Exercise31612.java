package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Exercise31612 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> letter = new TreeMap<>(Map.of('i', 2, 'j', 2, 'o', 1));
        int len = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        int count = 0;
        for (int i = 0; i < len; i++) {
            count += letter.get(input[i]);
        }
        System.out.println(count);
    }
}
