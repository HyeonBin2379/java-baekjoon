package bakjoon.bakjoon27XXX;

import java.util.Scanner;

public class Exercise27890 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            x = (x % 2 == 0) ? (x/2) ^ 6 : (x*2) ^ 6;
        }
        System.out.println(x);
    }
}
