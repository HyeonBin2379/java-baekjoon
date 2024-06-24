package bakjoon.bakjoon1XXX;

import java.util.Scanner;

public class Exercise1357 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(reverse(reverse(x) + reverse(y)));
    }

    public static int reverse(int num) {
        String reversed = new StringBuilder(Integer.toString(num)).reverse().toString();
        return Integer.parseInt(reversed);
    }
}
