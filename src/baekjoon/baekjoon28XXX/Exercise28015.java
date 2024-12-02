package baekjoon.baekjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise28015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = 0;
            for (int j = 0; j < m; j++) {
                int firstColor = line[j];
                if (firstColor == 0) {
                    continue;
                }
                for (int k = j; k < m; k++) {
                    if (line[k] == 0) {
                        break;
                    }
                    if (line[k] == firstColor) {
                        line[k] = 0;
                    }
                }
                count++;
            }
            answer += count;
        }
        System.out.println(answer);
    }
}
