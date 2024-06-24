package bakjoon.bakjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        for (int i = 1; i <= num; i++) {
            sb.append(i).append(" ");
            if (i % 6 == 0 || i == num) {
                sb.append("Go! ");
            }
        }
        br.close();
        System.out.println(sb);
    }
}
