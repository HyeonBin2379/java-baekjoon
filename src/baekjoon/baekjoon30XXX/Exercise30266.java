package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise30266 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            Set<String> alert = Arrays.stream(br.readLine().split("")).collect(Collectors.toSet());
            int count = 0;
            for (int j = 0; j < num; j++) {
                String[] input = br.readLine().split("");
                count += (Arrays.stream(input).anyMatch(alert::contains)) ? 1 : 0;
            }
            sb.append(String.format("Data Set %d:\n%d\n\n", i, count));
        }
        System.out.print(sb);
    }
}
