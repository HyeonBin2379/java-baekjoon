package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise17931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> result = new ArrayList<>();
        int next = 0;
        for (int i = 0; i < n; i++) {
            if (next < num[i]) {
                result.add(num[i]);
                next = num[i];
            }
        }
        System.out.println(result.size());
        System.out.println(result.stream().map(value -> Integer.toString(value)).collect(Collectors.joining(" ")));
    }
}
