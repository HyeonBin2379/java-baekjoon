package baekjoon.baekjoon25XXX;

import java.util.Scanner;

public class Exercise25915 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] pwd = "ILOVEYONSEI".toCharArray();
        char now = sc.nextLine().charAt(0);
        int answer = 0;
        for (char c : pwd) {
            answer += Math.abs(now - c);
            now = c;
        }
        System.out.println(answer);
    }
}
