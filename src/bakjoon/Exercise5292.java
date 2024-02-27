package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine().trim());
        for (int i = 1; i <= count; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                if (i % 15 == 0) {
                    sb.append("DeadMan\n");
                } else {
                    sb.append((i % 3 == 0) ? "Dead\n" : "Man\n");
                }
            } else {
                sb.append(i).append(" ");
            }
        }
        System.out.print(sb);
    }
}
