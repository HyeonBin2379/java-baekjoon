package bakjoon.bakjoon14XXX;

import java.util.Scanner;

public class Exercise14489 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value1 = sc.nextInt();
        int value2 = sc.nextInt();
        int chicken = sc.nextInt();
        sc.close();

        int sum = value1 + value2;
        System.out.println((sum >= chicken*2) ? sum - chicken*2 : sum);
    }
}
