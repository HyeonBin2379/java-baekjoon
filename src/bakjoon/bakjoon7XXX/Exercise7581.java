package bakjoon.bakjoon7XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise7581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0 0 0")) {
                break;
            }
            int[] num = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < 4; i++) {
                if (num[i] == 0) {
                    switch (i) {
                        case 0 -> num[i] = num[3] / (num[1] * num[2]);
                        case 1 -> num[i] = num[3] / (num[0] * num[2]);
                        case 2 -> num[i] = num[3] / (num[0] * num[1]);
                        case 3 -> num[i] = num[0] * num[1] * num[2];
                    }
                }
                sb.append(num[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
