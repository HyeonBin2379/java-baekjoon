package baekjoon.baekjoon11XXX;

import java.util.Scanner;

public class Exercise11816 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.startsWith("0x")) {
            System.out.println(Integer.parseInt(input.substring(2), 16));
        } else if (input.startsWith("0")) {
            System.out.println(Integer.parseInt(input, 8));
        } else {
            System.out.println(Integer.parseInt(input));
        }
    }
}
