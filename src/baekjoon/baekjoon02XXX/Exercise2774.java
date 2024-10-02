package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise2774 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            Set<Integer> numbers = Arrays.stream(br.readLine().split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
            sb.append(numbers.size()).append("\n");
        }
        System.out.print(sb);
    }
}
