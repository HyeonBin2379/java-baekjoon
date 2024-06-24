package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise6359 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            int count = 0;
            for (int j = 1; j*j <= num; j++) {
                count++;
            }
            System.out.println(count);
        }
    }
}
