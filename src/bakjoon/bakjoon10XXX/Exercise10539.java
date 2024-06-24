package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10539 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] b = new long[n+1];
        for (int i = 1; i <= n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        long[] a = new long[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = i*b[i]-(i-1)*b[i-1];
            sb.append(a[i]).append(" ");
        }
        System.out.println(sb);
    }
}
