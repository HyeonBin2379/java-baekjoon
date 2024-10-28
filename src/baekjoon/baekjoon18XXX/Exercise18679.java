package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise18679 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> vocabulary = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] tokens = Arrays.stream(br.readLine().split("[ =]"))
                    .filter(s -> !s.isEmpty())
                    .toArray(String[]::new);
            vocabulary.put(tokens[0], tokens[1]);
        }
        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            int m = Integer.parseInt(br.readLine());
            System.out.println(Arrays.stream(br.readLine().split(" ", m))
                    .map(vocabulary::get)
                    .collect(Collectors.joining(" ")));
        }
    }
}
