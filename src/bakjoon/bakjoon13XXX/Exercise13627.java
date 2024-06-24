package bakjoon.bakjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise13627 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        Set<Integer> returned = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        int[] result = IntStream.rangeClosed(1, n)
                .filter(value -> !returned.contains(value))
                .toArray();
        if (result.length == 0) {
            System.out.println("*");
        } else {
            Arrays.stream(result).forEach(value -> System.out.print(value + " "));
        }
    }
}
