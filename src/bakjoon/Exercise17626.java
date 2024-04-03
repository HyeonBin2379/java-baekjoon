package bakjoon;

import java.util.Scanner;

public class Exercise17626 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] count = new int[num+1];
        for (int i = 1; i <= num; i++) {
            count[i] = count[i-1] + 1;
            for (int j = 1; j*j <= i; j++) {
                count[i] = Math.min(count[i], count[i-j*j] + 1);
            }
        }
        System.out.println(count[num]);
    }
}
