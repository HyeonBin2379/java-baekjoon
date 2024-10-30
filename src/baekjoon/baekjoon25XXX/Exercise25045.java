package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise25045 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Long[] content = Arrays.stream(br.readLine().split(" ", n))
                .map(Long::parseLong)
                .sorted(Comparator.reverseOrder())
                .toArray(Long[]::new);
        Long[] cost = Arrays.stream(br.readLine().split(" ", m))
                .map(Long::parseLong)
                .sorted()
                .toArray(Long[]::new);
        System.out.println(IntStream.range(0, Math.min(n, m))
                .mapToLong(idx -> Math.max(content[idx]-cost[idx], 0))
                .reduce(0, Long::sum));
    }
}
