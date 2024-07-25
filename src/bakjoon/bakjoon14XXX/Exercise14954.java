package bakjoon.bakjoon14XXX;

import java.util.Scanner;

public class Exercise14954 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (true) {
            n = getSquareSum(n);
            if (n == 4) {
                System.out.println("UNHAPPY");
                break;
            } else if (n == 1) {
                System.out.println("HAPPY");
                break;
            }
        }
    }

    private static int getSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int r = n % 10;
            sum += r*r;
            n /= 10;
        }
        return sum;
    }
}
