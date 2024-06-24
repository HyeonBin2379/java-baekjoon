package bakjoon.bakjoon4XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0.00")) {
                break;
            }
            double length = 0;
            for (int i = 1; ; i++) {
                length += 1.0/(i+1);
                if (length >= Double.parseDouble(input)) {
                    sb.append(String.format("%d card(s)\n", i));
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}
