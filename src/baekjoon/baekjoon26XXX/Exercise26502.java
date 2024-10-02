package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise26502 {

    private static final Map<Character, Character> decoder = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        setDecoder();
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                if (decoder.containsKey(input[j])) {
                    input[j] = decoder.get(input[j]);
                }
            }
            System.out.println(new String(input));
        }
    }

    private static void setDecoder() {
        decoder.put('a', 'e');
        decoder.put('e', 'i');
        decoder.put('i', 'o');
        decoder.put('o', 'u');
        decoder.put('u', 'y');
        decoder.put('y', 'a');
        decoder.put('A', 'E');
        decoder.put('E', 'I');
        decoder.put('I', 'O');
        decoder.put('O', 'U');
        decoder.put('U', 'Y');
        decoder.put('Y', 'A');
    }
}
