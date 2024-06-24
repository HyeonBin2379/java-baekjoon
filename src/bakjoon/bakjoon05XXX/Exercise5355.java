package bakjoon.bakjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5355 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] cmd = br.readLine().split(" ");
            double result = Double.parseDouble(cmd[0]);
            for (int j = 1; j < cmd.length; j++) {
                switch (cmd[j]) {
                    case "@" -> result *= 3;
                    case "%" -> result += 5;
                    case "#" -> result -= 7;
                }
            }
            System.out.printf("%.2f\n", result);
        }
    }
}
