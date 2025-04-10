package algorithm.backtracking;

import java.util.Scanner;

public class Exercise9663 {

    private static int n, count;
    private static int[] column;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        column = new int[n];
        backtracking(0);
        System.out.println(count);
    }

    private static boolean isPromise(int level) {
        for (int i = 0; i < level; i++) {
            if (column[i] == column[level]
                    || level-i == Math.abs(column[level] - column[i])) {
                return false;
            }
        }
        return true;
    }
    private static void backtracking(int level) {
        if (level == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            column[level] = i;
            if (isPromise(level)) {
                backtracking(level+1);
            }
        }
    }
}
