package bakjoon.bakjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise29718 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] clap = new int[m];
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                clap[j] += row[j];
            }
        }
        int a = Integer.parseInt(br.readLine());

        // 슬라이딩 윈도우 사용
        int window = Arrays.stream(clap, 0, a).sum();
        int answer = window;
        for (int i = a; i < clap.length; i++) {
            window += clap[i] - clap[i-a];
            if (window > answer) {
                answer = window;
            }
        }
        System.out.println(answer);
    }
}
