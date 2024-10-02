package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise31416 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tA = Integer.parseInt(st.nextToken());
            int tB = Integer.parseInt(st.nextToken());
            int vA = Integer.parseInt(st.nextToken());
            int vB = Integer.parseInt(st.nextToken());

            int answer = Integer.MAX_VALUE;
            for (int j = 0; j < vA+1; j++) {
                int temp = Math.max(tA * j, tA * (vA-j) + tB * vB);
                answer = Math.min(answer, temp);
            }
            System.out.println(answer);
        }
    }
}
