package bakjoon.bakjoon07XXX;

import java.util.Scanner;

public class Exercise7789 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (isPrimeNum(a) && isPrimeNum(b*(int)1e6+a)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isPrimeNum(int num) {
        for (int i = 2; i*i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
