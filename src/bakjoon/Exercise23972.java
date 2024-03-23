package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise23972 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long k = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());

        if (n == 1) {
            System.out.println(-1);
            return;
        }
        long x = k*n % (n-1) == 0 ? k*n/(n-1) : k*n/(n-1)+1;
        System.out.println(x >= 0 && n > 1 ? x : -1);
    }
}
