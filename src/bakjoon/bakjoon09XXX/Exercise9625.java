package bakjoon.bakjoon09XXX;

import java.util.Scanner;

public class Exercise9625 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] num = new int[46];
        num[1] = 1;
        for (int i = 2; i <= 45; i++) {
            num[i] = num[i-1] + num[i-2];
        }
        System.out.println(num[k-1] + " " + num[k]);
    }
}
