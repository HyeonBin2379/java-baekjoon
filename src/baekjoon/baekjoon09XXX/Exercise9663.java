package baekjoon.baekjoon09XXX;

import java.util.Scanner;

public class Exercise9663 {

    private static int n, answer;
    private static int[] col;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        col = new int[n];
        search(0);
        System.out.println(answer);
    }

    private static boolean isPossible(int level) {
        for (int i = 0; i < level; i++) {
            if (col[i] == col[level]) {
                return false;
            } else if (level-i == Math.abs(col[level]-col[i])) {
                return false;
            }
        }
        return true;
    }
    private static void search(int level) {
        if (level == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            col[level] = i;
            if (isPossible(level)) {
                search(level+1);
            }
        }
    }
}
