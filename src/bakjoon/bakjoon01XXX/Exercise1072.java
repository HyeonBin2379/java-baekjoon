package bakjoon.bakjoon01XXX;

import java.util.Scanner;

public class Exercise1072 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();
        long z = 100 * y / x;

        if (z >= 99) {
            System.out.println(-1);
            return;
        }
        long start = 0;
        long end = (long)1e9;

        while (start < end) {
            long mid = (start + end) / 2;
            long ret = 100 * (y+mid) / (x+mid);

            if (ret > z) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        System.out.println(end);
    }
}
