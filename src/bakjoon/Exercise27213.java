package bakjoon;

import java.util.Scanner;

public class Exercise27213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println((m < 3 || n < 3) ? m*n : 2*(m+n)-4);
    }
}
