package bakjoon.bakjoon9XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9791 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }

            int[] num = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
            int sequence = 0;
            boolean isOne = false;
            for (int i = 0; i <= num.length; i++) {
                if (i == 0) {
                    sequence++;
                    isOne = num[i] == 1;
                } else if (i == num.length) {
                    sb.append(sequence).append(isOne ? 1 : 0);
                } else if (num[i-1] == num[i]){
                    sequence++;
                } else {
                    sb.append(sequence).append(isOne ? 1 : 0);
                    sequence = 1;
                    isOne = !isOne;
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
