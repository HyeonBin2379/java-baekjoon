package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0 W 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int balance = Integer.parseInt(st.nextToken());
            String cmd = st.nextToken();
            int amount = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case "D" -> sb.append(balance + amount).append("\n");
                case "W" -> sb.append((balance - amount < -200) ? "Not allowed" : balance - amount).append("\n");
            }
        }
        System.out.print(sb);
    }
}
