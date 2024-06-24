package bakjoon.bakjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise18408 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[3];
        int one = 0;
        for (int i = 0; i < 3; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            one += (num[i] == 1) ? 1 : 0;
        }
        System.out.println((one > 3-one) ? 1 : 2);
    }
}
