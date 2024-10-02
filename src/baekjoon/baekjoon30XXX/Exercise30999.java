package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise30999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String vote = br.readLine();
            int pros = (int) Arrays.stream(vote.split(""))
                    .filter(s -> s.equals("O"))
                    .count();
            answer += (pros > m/2) ? 1 : 0;
        }
        System.out.println(answer);
        br.close();
    }
}
