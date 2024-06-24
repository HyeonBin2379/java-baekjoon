package bakjoon.bakjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise21339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        double avg = (double) (n*d-k*s)/(n-k);
        if (avg < 0 || avg > 100) {
            System.out.println("impossible");
            return;
        }
        System.out.printf("%.6f\n", avg);
    }
}
