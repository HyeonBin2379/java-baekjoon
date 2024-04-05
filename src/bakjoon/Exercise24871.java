package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise24871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long d = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long i = Long.parseLong(st.nextToken());
        long j = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long totalDays = (k-1)*(d*m) + (j-1)*d + (i-1);
        System.out.println((char)('a' + (totalDays % w)));
    }
}
