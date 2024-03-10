package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise16479 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d1 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int min = Math.min(d1, d2);
        int max = Math.max(d1, d2);
        System.out.println((min == max) ? k*k : k*k - (Math.pow(max-min, 2)/4.0));
    }
}
