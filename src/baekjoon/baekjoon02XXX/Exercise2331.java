package baekjoon.baekjoon02XXX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise2331 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int p = sc.nextInt();

        List<Integer> result = new ArrayList<>();
        result.add(a);

        int now = a;
        while (true) {
            now = getNextNum(now, p);
            if (result.contains(now)) {
                System.out.println(result.indexOf(now));
                return;
            }
            result.add(now);
        }
    }

    private static int getNextNum(int now, int pow) {
        int next = 0;
        while (now > 0) {
            int temp = now % 10;
            next += (int) Math.pow(temp, pow);
            now /= 10;
        }
        return next;
    }
}
