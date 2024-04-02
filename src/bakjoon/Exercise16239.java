package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise16239 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            if (i < n) {
                System.out.println(i);
                k -= i;
            } else {
                System.out.println(k);
            }
        }
    }
}
