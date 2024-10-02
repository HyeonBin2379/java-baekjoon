package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise12085 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] name = new String[n];
            for (int j = 0; j < n; j++) {
                name[j] = br.readLine();
            }
            int answer = 0;
            int k = 0;
            for (int j = 1; j < n; j++) {
                if (name[j].compareTo(name[k]) < 0) {
                    answer++;
                } else {
                    k = j;
                }
            }
            sb.append(String.format("Case #%d: %d\n", i, answer));
        }
        System.out.print(sb);
    }
}
