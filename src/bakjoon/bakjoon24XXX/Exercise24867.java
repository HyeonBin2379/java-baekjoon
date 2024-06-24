package bakjoon.bakjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise24867 {
    private static long k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long b = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        System.out.println(Math.max(getCount(a, b, x, y), getCount(b, a, y, x)));
    }

    public static long getCount(long first, long second, long perMin1, long perMin2) {
        long total = 0;
        if (first < k) {
            total = (k-first)*perMin1;
            if (second < k-first) {
                total += (k-first-second)*perMin2;
            }
        }
        return total;
    }
}
