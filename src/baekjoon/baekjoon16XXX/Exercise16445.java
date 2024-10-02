package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise16445 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < testCase; i++) {
            int answer = Integer.parseInt(br.readLine());
            if (answer != 1) {
                count++;
            }
        }
        System.out.println(count);
    }
}
