package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise14649 {

    private static final int[] bridge = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            switch (direction) {
                case "L" -> IntStream.range(1, pos).forEach(i -> bridge[i]++);
                case "R" -> IntStream.rangeClosed(pos+1, 100).forEach(i -> bridge[i]++);
            }
        }
        Map<Integer, Long> result = IntStream.rangeClosed(1, 100)
                .map(i -> bridge[i])
                .boxed()
                .collect(Collectors.groupingBy(i -> i % 3, Collectors.counting()));
        IntStream.rangeClosed(0, 2)
                .forEach(key -> System.out.printf("%.2f\n", (double)total*result.getOrDefault(key, 0L)/100));
    }
}
