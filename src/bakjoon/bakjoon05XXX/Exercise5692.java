package bakjoon.bakjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise5692 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] factorial = {1, 1, 2, 6, 24, 120};
        while (true) {
            int[] num = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            if (num[0] == 0) {
                break;
            }
            int decimal = 0;
            for (int i = 0; i < num.length; i++) {
                decimal += num[i]*factorial[num.length-i];
            }
            sb.append(decimal).append("\n");
        }
        System.out.print(sb);
    }
}
