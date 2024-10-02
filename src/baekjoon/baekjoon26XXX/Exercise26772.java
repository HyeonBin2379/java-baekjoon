package baekjoon.baekjoon26XXX;

import java.util.Scanner;

public class Exercise26772 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(
                  " @@@   @@@  ".repeat(num) + "\n"
                + "@   @ @   @ ".repeat(num) + "\n"
                + "@    @    @ ".repeat(num) + "\n"
                + "@         @ ".repeat(num) + "\n"
                + " @       @  ".repeat(num) + "\n"
                + "  @     @   ".repeat(num) + "\n"
                + "   @   @    ".repeat(num) + "\n"
                + "    @ @     ".repeat(num) + "\n"
                + "     @      ".repeat(num));
    }
}
