package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise11034 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            int[] kang = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            int diff1 = kang[1]-kang[0];
            int diff2 = kang[2]-kang[1];
            sb.append(Math.max(diff1, diff2)-1).append("\n");
        }
        System.out.print(sb);
    }
}
