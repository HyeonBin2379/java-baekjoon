package baekjoon.baekjoon09XXX;

import java.util.Scanner;

public class Exercise9657 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean[] isSKWin = new boolean[num+1];
        for (int i = 1; i <= num; i++) {
            if (i <= 4) {
                isSKWin[i] = i != 2;
            } else {
                isSKWin[i] = !(isSKWin[i-1] && isSKWin[i-3] && isSKWin[i-4]);
            }
        }
        System.out.println(isSKWin[num] ? "SK" : "CY");

    }
}
