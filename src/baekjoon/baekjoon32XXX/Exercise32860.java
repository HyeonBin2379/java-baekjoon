package baekjoon.baekjoon32XXX;

import java.util.Scanner;

public class Exercise32860 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if (m <= 26) {
            System.out.printf("SN %d%c", n, (char)('A' + m-1));
            return;
        }
        StringBuilder sb = new StringBuilder();
        m -= 27;
        sb.append((char)('a'+(m%26))).append((char)('a'+(m/26)));
        System.out.printf("SN %d%s", n, sb.reverse());
    }
}
