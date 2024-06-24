package bakjoon.bakjoon14XXX;

import java.util.Scanner;

public class Exercise14682 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = Long.parseLong(sc.nextLine());
        long k = Long.parseLong(sc.nextLine());
        long sum = 0L;
        for (int i = 0; i <= k; i++) {
            sum += n*Math.pow(10, i);
        }
        System.out.println(sum);
    }
}
