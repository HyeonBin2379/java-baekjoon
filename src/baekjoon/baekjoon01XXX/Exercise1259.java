package baekjoon.baekjoon01XXX;

import java.util.Scanner;

public class Exercise1259 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            if (input.equals("0")) {
                break;
            }
            String[] digits = input.split("");
            System.out.println(isPalindrome(digits) ? "yes" : "no");
        }
    }

    private static boolean isPalindrome(String[] digits) {
        int len = digits.length;
        for (int i = 0; i < digits.length/2; i++) {
            if (!digits[i].equals(digits[len-1-i])) {
                return false;
            }
        }
        return true;
    }
}
