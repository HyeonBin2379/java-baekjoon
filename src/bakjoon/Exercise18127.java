package bakjoon;

import java.util.Scanner;

public class Exercise18127 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        long sum = 1;
        for (int i = 1; i <= b; i++) {
            sum += (long) (a - 2) * i + 1;
        }
        System.out.println(sum);
    }
}
