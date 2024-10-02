package baekjoon.baekjoon06XXX;

import java.util.Scanner;

public class Exercise6975 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(sc.nextLine());
            int sum = getSum(num);
            if (num > sum) {
                System.out.println(num + " is a deficient number.\n");
            } else if (num == sum) {
                System.out.println(num + " is a perfect number.\n");
            } else {
                System.out.println(num + " is an abundant number.\n");
            }
        }
    }

    public static int getSum(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
