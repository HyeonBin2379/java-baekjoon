package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise13877 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int testNum = Integer.parseInt(st.nextToken());
            String num = st.nextToken();
            int octal;
            try {
                octal = Integer.parseInt(num, 8);
            } catch (Exception e) {
                octal = 0;
            }
            sb.append(String.format("%d %d %d %d\n", testNum, octal, Integer.parseInt(num), Integer.parseInt(num, 16)));
        }
        System.out.print(sb);
    }
}
