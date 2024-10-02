package baekjoon.baekjoon03XXX;

import java.util.Scanner;

public class Exercise3578 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();

        if (h < 2) {
            System.out.println((h == 0) ? "1" : "0");
            return;
        }
        String result = (h % 2 == 1) ? "4" : "";
        result += "8".repeat(h/2);
        System.out.println(result);
    }
}
