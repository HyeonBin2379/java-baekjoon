package baekjoon.baekjoon27XXX;

import java.util.Scanner;

public class Exercise27257 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int count = (int) num.chars().filter(value -> value == '0').count();
        for (int i = num.length()-1; i >= 0; i--) {
            if (num.charAt(i) != '0') {
                break;
            }
            count--;
        }
        System.out.println(count);
    }
}
