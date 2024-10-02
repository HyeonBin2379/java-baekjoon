package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise12352 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            int len = Integer.parseInt(br.readLine());
            double[] num = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            for (int j = 1; j < len-1; j++) {
                double avg = (num[j-1]+num[j+1])/2.0;
                num[j] = Math.min(num[j], avg);
            }
            sb.append(String.format("Case #%d: %.4f\n", i, num[len-2]));
        }
        System.out.print(sb);
    }
}
