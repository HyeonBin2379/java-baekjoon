package algorithm.dp;

import java.util.Scanner;

public class Exercise9657 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] isFirstWin = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            if (i <= 4) {
                isFirstWin[i] = (i != 2);
            } else {
                isFirstWin[i] = !(isFirstWin[i-1] && isFirstWin[i-3] && isFirstWin[i-4]);
            }
        }
        System.out.println(isFirstWin[n] ? "SK" : "CY");
    }
}
