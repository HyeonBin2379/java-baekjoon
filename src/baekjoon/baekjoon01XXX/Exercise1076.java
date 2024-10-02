package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> resistant = new LinkedHashMap<>(Map.of(
                "black", 0,
                "brown", 1,
                "red", 2,
                "orange", 3,
                "yellow", 4,
                "green", 5,
                "blue", 6,
                "violet", 7,
                "grey", 8,
                "white", 9
        ));
        StringBuilder num = new StringBuilder();
        long result = 0L;
        for (int i = 0; i < 3; i++) {
            String color = br.readLine();
            if (i < 2) {
                num.append(resistant.get(color).toString());
            } else {
                result = Long.parseLong(num.toString()) * (long) Math.pow(10, resistant.get(color));
            }
        }
        System.out.println(result);
    }
}
