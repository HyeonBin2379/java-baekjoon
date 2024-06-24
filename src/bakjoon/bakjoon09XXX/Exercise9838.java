package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise9838 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] received = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            received[num] = i;
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(received[i]);
        }
    }
}
