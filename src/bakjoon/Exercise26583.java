package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise26583 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            int[] num = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < num.length; i++) {
                if (i == 0) {
                    sb.append(num[i]*num[i+1]).append(" ");
                } else if (i == num.length-1) {
                    sb.append(num[i-1]*num[i]).append(" ");
                } else {
                    sb.append(num[i-1]*num[i]*num[i+1]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
