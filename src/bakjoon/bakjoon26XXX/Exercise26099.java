package bakjoon.bakjoon26XXX;

import java.util.Scanner;

public class Exercise26099 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int answer = 0;
        while (n % 5 > 0) {
            n -= 3;
            answer++;
        }
        System.out.println(n < 0 ? -1 : answer + n/5);
    }
}
