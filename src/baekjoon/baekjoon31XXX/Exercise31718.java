package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Exercise31718 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> result = new HashMap<>();
        for (Integer num : numbers) {
            while (num % 2 == 0) {
                num /= 2;
            }
            result.merge(num, 1, Integer::sum);
        }
        System.out.println(result.values().stream().reduce(0, Integer::max));
    }
}
