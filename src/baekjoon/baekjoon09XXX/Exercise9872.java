package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise9872 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> result = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String key = Arrays.stream(br.readLine().split(" ")).sorted().collect(Collectors.joining(" "));
            result.merge(key, 1, Integer::sum);
        }
        System.out.println(result.values().stream().reduce(0, Integer::max));
    }
}
