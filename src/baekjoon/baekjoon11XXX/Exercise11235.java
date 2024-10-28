package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Exercise11235 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> votes = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            votes.merge(name, 1, Integer::sum);
        }
        int max = votes.values().stream().reduce(0, Integer::max);
        votes.keySet().stream()
                .filter(s -> votes.get(s) == max)
                .sorted()
                .forEach(System.out::println);
    }
}
