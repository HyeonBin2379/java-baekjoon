package bakjoon.bakjoon3XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise3058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int[] even = Arrays.stream(br.readLine().split(" "))
                    .filter(s -> Integer.parseInt(s) % 2 == 0)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Arrays.sort(even);
            sb.append(String.format("%d %d\n", Arrays.stream(even).sum(), even[0]));
        }
        System.out.print(sb);
    }
}
