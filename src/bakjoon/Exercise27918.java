package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise27918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int round = Integer.parseInt(br.readLine());
        int d = 0, p = 0;
        for (int i = 0; i < round; i++) {
            String winner = br.readLine();
            if (Math.abs(d-p) == 2) {
                break;
            }
            switch (winner) {
                case "D" -> d++;
                case "P" -> p++;
            }
        }
        br.close();
        System.out.print(d + ":" + p);
    }
}
