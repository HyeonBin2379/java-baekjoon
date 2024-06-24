package bakjoon.bakjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise13484 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());
        int data = x;
        for (int i = 0; i < n; i++) {
            int used = Integer.parseInt(br.readLine().trim());
            data = Math.max(data-used, 0);
            data += x;
        }
        System.out.println(data);
    }
}
