package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise16625 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= s; i++) {
            if (i % p == 0 && i % q == 0) {
                System.out.println("yes");
                return;
            }
        }
        System.out.println("no");
    }
}
