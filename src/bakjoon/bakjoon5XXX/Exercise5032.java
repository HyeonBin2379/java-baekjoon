package bakjoon.bakjoon5XXX;

import java.util.Scanner;

public class Exercise5032 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int f = sc.nextInt();
        int c = sc.nextInt();

        int now = e+f;
        int answer = 0;
        while (now >= c) {
            e = now/c;
            f = now % c;
            now = e+f;
            answer += e;
        }
        System.out.println(answer);
    }
}
