package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise25830 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = start; i <= end; i++) {
            int[] num = Arrays.stream(Integer.toString(i).split("")).mapToInt(Integer::parseInt).toArray();
            count += (int) Arrays.stream(num).filter(value -> value == n).count();
        }
        System.out.println(count);
    }
}
