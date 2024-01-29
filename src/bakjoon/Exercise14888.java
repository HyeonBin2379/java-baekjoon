package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14888 {
    private static int[] numbers, countByOp;
    private static final int[] answer = {Integer.MIN_VALUE, Integer.MAX_VALUE};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCount = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" ", numCount)).mapToInt(Integer::parseInt).toArray();
        countByOp = Arrays.stream(br.readLine().split(" ", 4)).mapToInt(Integer::parseInt).toArray();
        br.close();

        backtracking(numbers[0], 1);
        for (int j : answer) {
            System.out.println(j);
        }
    }

    public static void backtracking(int num, int step) {
        if (step == numbers.length) {
            answer[0] = Math.max(answer[0], num);
            answer[1] = Math.min(answer[1], num);
            return;
        }

        for (int i = 0; i < countByOp.length; i++) {
            if (countByOp[i] > 0) {
                countByOp[i]--;
                switch (i) {
                    case 0 -> backtracking(num + numbers[step], step + 1);
                    case 1 -> backtracking(num - numbers[step], step + 1);
                    case 2 -> backtracking(num * numbers[step], step + 1);
                    case 3 -> backtracking(num / numbers[step], step + 1);
                }
                countByOp[i]++;
            }
        }
    }
}
