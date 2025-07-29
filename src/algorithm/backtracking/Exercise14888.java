package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14888 {

    private static int n, max, min;
    private static int[] num, op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        op = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        backtracking(num[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void backtracking(int total, int count) {
        if (count == n) {
            max = Math.max(total, max);
            min = Math.min(total, min);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                switch (i) {
                    case 0 -> backtracking(total + num[count], count + 1);
                    case 1 -> backtracking(total - num[count], count + 1);
                    case 2 -> backtracking(total * num[count], count + 1);
                    case 3 -> {
                        int value = (total < 0) ? -(Math.abs(total) / num[count]) : (Math.abs(total) / num[count]);
                        backtracking(value, count + 1);
                    }
                }
                op[i]++;
            }
        }
    }
}
