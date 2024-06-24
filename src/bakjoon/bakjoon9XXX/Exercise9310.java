package bakjoon.bakjoon9XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9310 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            int[] seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int answer;
            if (2*seq[1] == seq[0]+seq[2] || seq[1] % seq[0] != 0) {
                int diff = seq[1]-seq[0];
                answer = n*(2*seq[0]+(n-1)*diff)/2;
            } else {
                int diff = seq[1]/seq[0];
                answer = seq[0]*((int) Math.pow(diff, n)-1)/(diff-1);
            }
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
}
