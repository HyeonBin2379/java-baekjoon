package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise9286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            int count = Integer.parseInt(br.readLine());
            sb.append(String.format("Case %d:\n", i));
            for (int j = 0; j < count; j++) {
                int grade = Integer.parseInt(br.readLine());
                if (grade != 6) {
                    sb.append(grade+1).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
