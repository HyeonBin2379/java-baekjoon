package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise4619 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (num[0] == 0 && num[1] == 0) {
                break;
            }

            int i = 0;
            while (Math.pow(i, num[1]) < num[0]) {
                i++;
            }
            sb.append(Math.pow(i, num[1])-num[0] < num[0]-Math.pow(i-1, num[1]) ? i : i-1).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
