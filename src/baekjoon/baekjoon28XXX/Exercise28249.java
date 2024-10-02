package baekjoon.baekjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise28249 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> pepper = new LinkedHashMap<>(Map.of(
                "Poblano", 1500,
                "Mirasol", 6000,
                "Serrano", 15500,
                "Cayenne", 40000,
                "Thai", 75000,
                "Habanero", 125000
        ));
        int count = Integer.parseInt(br.readLine());
        long sum = 0L;
        for (int i = 0; i < count; i++) {
            sum += pepper.get(br.readLine());
        }
        System.out.println(sum);
    }
}
