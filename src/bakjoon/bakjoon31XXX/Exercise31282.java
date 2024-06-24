package bakjoon.bakjoon31XXX;

import java.util.Scanner;

public class Exercise31282 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int jump = 0;
        for (int i = 0; i < n; i += k, n += m) {
            jump++;
        }
        System.out.println(jump);
    }
}
