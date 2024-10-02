package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise5361 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        double[] price = {350.34, 230.90, 190.55, 125.30, 180.90};
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            int[] quantity = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            double sum = 0d;
            for (int j = 0; j < 5; j++) {
                sum += price[j]*quantity[j];
            }
            sb.append(String.format("$%.2f\n", sum));
        }
        System.out.print(sb);
    }
}
