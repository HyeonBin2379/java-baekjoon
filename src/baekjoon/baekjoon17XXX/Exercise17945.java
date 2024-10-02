package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise17945 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a*a == b) {
            System.out.println(-a);
        } else {
            double sqrt = Math.sqrt(a * a - b);
            int ans1 = -a - (int)sqrt;
            int ans2 = -a + (int)sqrt;
            System.out.println(Math.min(ans1, ans2) + " " + Math.max(ans1, ans2));
        }
    }
}
