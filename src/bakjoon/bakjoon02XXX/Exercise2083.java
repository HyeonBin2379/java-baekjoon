package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("# 0 0")) {
                break;
            }
            String[] token = input.split(" ");
            sb.append(token[0]).append(" ");
            if (Integer.parseInt(token[1]) > 17 || Integer.parseInt(token[2]) >= 80) {
                sb.append("Senior").append("\n");
            } else {
                sb.append("Junior").append("\n");
            }
        }
        br.close();
        System.out.print(sb);
    }
}
