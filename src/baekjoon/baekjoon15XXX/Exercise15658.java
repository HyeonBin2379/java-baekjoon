package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise15658 {

    private static int n;
    private static int max = -1000000001;
    private static int min = 1000000001;
    private static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] op = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        backtracking(1, num[0], op[0], op[1], op[2], op[3]);
        System.out.println(max + "\n" + min);
    }

    private static void backtracking(int step, int result, int plus, int minus, int mul, int div) {
        if (step == n) {
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }

        if (plus > 0) {
            backtracking(step+1, result+num[step], plus-1, minus, mul, div);
        }
        if (minus > 0) {
            backtracking(step+1, result-num[step], plus, minus-1, mul, div);
        }
        if (mul > 0) {
            backtracking(step+1, result*num[step], plus, minus, mul-1, div);
        }
        if (div > 0) {
            backtracking(step+1, result/num[step], plus, minus, mul, div-1);
        }
    }
}
