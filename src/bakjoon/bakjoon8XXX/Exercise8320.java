package bakjoon.bakjoon8XXX;

import java.util.Scanner;

public class Exercise8320 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += n / i;
        }
        for (int i = 1; i*i <= n; i++) {
            total++;
        }
        System.out.println(total/2);
    }
}
