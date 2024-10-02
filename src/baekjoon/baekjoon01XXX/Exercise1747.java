package baekjoon.baekjoon01XXX;

import java.util.Scanner;

public class Exercise1747 {
    private static final int MAX = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sieve(number);
    }

    public static void sieve(int number) {
        int[] primeNumber = new int[MAX*2];
        for (int i = 2; i < MAX*2; i++) {
            primeNumber[i] = i;
        }
        for (int i = 2; i < MAX*2; i++) {
            if (primeNumber[i] == 0) {
                continue;
            }
            if (primeNumber[i] >= number && isPalindrome(i)) {
                System.out.println(i);
                return;
            }

            for (int j = i*2; j < MAX*2; j += i) {
                if (primeNumber[j] == j) {
                    primeNumber[j] = 0;
                }
            }
        }
    }
    public static boolean isPalindrome(int number) {
        char[] temp = Integer.toString(number).toCharArray();
        for (int i = 0; i < temp.length/2; i++) {
            if (temp[i] != temp[temp.length-1-i]) {
                return false;
            }
        }
        return true;
    }
}
