package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise9806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int child = Integer.parseInt(br.readLine());
        int exp = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < child; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > 0) {
                sum += (int) Math.pow(num, exp);
            } else {
                sum += (exp % 2 == 0) ? (int)Math.pow(num, exp) : 0;
            }
        }
        System.out.println(sum);
    }
}
