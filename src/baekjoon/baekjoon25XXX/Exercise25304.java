package baekjoon.baekjoon25XXX;

import java.util.Scanner;

public class Exercise25304 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int n = sc.nextInt();

        int sum = 0;
        while (n-- > 0) {
            int price = sc.nextInt();
            int quantity = sc.nextInt();
            sum += price * quantity;
        }

        System.out.println(total == sum ? "Yes" : "No");
    }
}
