package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise15838 {

    private static final double[] retailPrice = {0.8, 1.0, 1.2, 0.8};
    private static final double[] meatCost = {7.5, 24.0, 32.0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            double profits = 0.0;
            double cost = 0.0;
            for (int i = 0; i < n; i++) {
                int[] amounts = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                profits += IntStream.range(0, 4).mapToDouble(index -> retailPrice[index]*amounts[index]).sum();
                cost += (amounts[3]*0.2) + IntStream.range(0, 3).mapToDouble(idx -> (meatCost[idx]+8)*amounts[idx]/85).sum();
            }
            sb.append(String.format("Case #%d: RM%.2f\n", ++count, profits-cost));
        }
        System.out.print(sb);
    }
}
