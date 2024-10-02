package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2992 {

    private static String[] digits;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nextPermutation(n);
    }

    private static void nextPermutation(int n) {
        digits =Integer.toString(n).split("");
        int i = digits.length-1;
        while (i > 0 && digits[i-1].compareTo(digits[i]) >= 0) {
            i--;
        }
        if (i <= 0) {
            System.out.println(0);
            return;
        }

        int j = digits.length-1;
        while (digits[j].compareTo(digits[i-1]) <= 0) {
            j--;
        }
        swap(i-1, j);

        j = digits.length-1;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
        System.out.println(String.join("", digits));
    }

    private static void swap(int a, int b) {
        String temp = digits[a];
        digits[a] = digits[b];
        digits[b] = temp;
    }
}
