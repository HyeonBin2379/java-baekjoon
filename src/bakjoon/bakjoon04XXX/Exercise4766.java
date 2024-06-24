package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        double prev = Double.parseDouble(br.readLine());
        while (true) {
            double num = Double.parseDouble(br.readLine());
            if (num == 999) {
                break;
            }
            sb.append(String.format("%.2f", num - prev)).append("\n");
            prev = num;
        }
        System.out.print(sb);
    }
}
