package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise21665 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] before = new int[r][c];
        for (int i = 0; i < r; i++) {
            before[i] = Arrays.stream(br.readLine().split("")).mapToInt(value -> (value.equals("B")) ? 0 : 1).toArray();
        }
        br.readLine();

        int count = 0;
        int[][] after = new int[r][c];
        for (int i = 0; i < r; i++) {
            after[i] = Arrays.stream(br.readLine().split("")).mapToInt(value -> (value.equals("B")) ? 1 : 0).toArray();
            for (int j = 0; j < c; j++) {
                count += (after[i][j] != before[i][j]) ? 1 : 0;
            }
        }
        System.out.println(count);
    }
}
