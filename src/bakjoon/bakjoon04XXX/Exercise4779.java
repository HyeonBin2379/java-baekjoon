package bakjoon.bakjoon04XXX;

import java.util.Scanner;

public class Exercise4779 {

    private static StringBuilder answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int exp = sc.nextInt();
            int len = (int) Math.pow(3, exp);

            answer = new StringBuilder();
            answer.append("-".repeat(Math.max(0, len)));
            func(0, len);
            System.out.println(answer);
        }
        sc.close();
    }

    public static void func(int start, int len) {
        if (len == 1) {
            return;
        }

        int newLen = len/3;
        for (int i = start+newLen; i < start+newLen*2; i++) {
            answer.setCharAt(i, ' ');
        }

        func(start, newLen);
        func(start+newLen*2, newLen);
    }
}
