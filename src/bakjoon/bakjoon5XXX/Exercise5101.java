package bakjoon.bakjoon5XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise5101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            long[] seq = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            if (seq[0] == 0 && seq[1] == 0 && seq[2] == 0) {
                break;
            }
            long diff = seq[2] - seq[0];
            if (diff % seq[1] == 0 && diff / seq[1] >= 0) {
                sb.append(diff/seq[1] + 1).append("\n");
            } else {
                sb.append("X").append("\n");
            }
        }
        System.out.print(sb);
    }
}
