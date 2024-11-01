package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise5366 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> result = new LinkedHashMap<>();

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            result.merge(input, 1, Integer::sum);
        }
        int total = result.values().stream().reduce(0, Integer::sum);

        result.forEach((s, count) -> System.out.println(s + ": " + count));
        System.out.println("Grand Total: " + total);
    }
}
