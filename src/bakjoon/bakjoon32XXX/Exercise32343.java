package bakjoon.bakjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise32343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int max = 0;
        for (int i = (1 << n)-1; i >= 0; i--) {
            for (int j = (1 << n)-1; j >= 0; j--) {
                if (Integer.bitCount(i) == a && Integer.bitCount(j) == b) {
                    max = Math.max(i^j, max);
                }
            }
        }
        System.out.println(max);
    }
}
