package baekjoon.baekjoon16XXX;

import java.util.Scanner;

public class Exercise16968 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] format = sc.nextLine().toCharArray();

        int total = format[0] == 'c' ? 26 : 10;
        for (int i = 1; i < format.length; i++) {
            if (format[i-1] == format[i]) {
                total *= (format[i] == 'c') ? 25 : 9;
            } else {
                total *= format[i] == 'c' ? 26 : 10;
            }
        }
        System.out.println(total);
    }
}
