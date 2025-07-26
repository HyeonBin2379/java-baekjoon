package algorithm.dp;

import java.util.HashMap;
import java.util.Scanner;

public class Exercise1351 {

    private static final HashMap<Long, Long> arr = new HashMap<>();

    private static long p, q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        p = sc.nextLong();
        q = sc.nextLong();

        System.out.println(dp(n));
    }

    private static long dp(long num) {
        if (arr.getOrDefault(num, 0L) != 0) {
            return arr.get(num);
        }
        if (num == 0) {
            arr.put(num, 1L);
            return arr.get(num);
        }
        arr.put(num, dp(num/p)+dp(num/q));

        return arr.get(num);
    }
}
