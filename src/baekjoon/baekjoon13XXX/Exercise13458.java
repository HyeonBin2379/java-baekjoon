package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise13458 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] examinee = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long answer = n;

        for (int i = 0; i < n; i++) {
            if (examinee[i]-b > 0) {
                answer += Math.ceil((double)(examinee[i]-b)/c);
            }
        }
        System.out.println(answer);
    }
}
