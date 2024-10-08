package baekjoon.baekjoon14XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise14650 {

    private static int n, count;
    private static int[] selected;
    private static final int[] num = {0, 1, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        selected = new int[n];
        Arrays.fill(selected, -1);
        backtracking(0);
        System.out.println(count);
    }

    private static void backtracking(int cnt) {
        if (cnt == n) {
            if (Arrays.stream(selected).sum() % 3 == 0) {
                count++;
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (cnt == 0 && num[i] == 0) {
                continue;
            }
            selected[cnt] = num[i];
            backtracking(cnt+1);
            selected[cnt] = -1;
        }
    }
}
