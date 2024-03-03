package bakjoon;

import java.util.Scanner;

public class Exercise27465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while (true) {
            if (!isPrimeNum(num)) {
                System.out.println(num);
                break;
            }
            num++;
        }
    }

    public static boolean isPrimeNum(int num) {
        for (int i = 2; i*i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
