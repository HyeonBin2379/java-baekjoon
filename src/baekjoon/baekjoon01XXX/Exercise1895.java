package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise1895 {

    private static int[][] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        num = new int[n][m];
        for (int i = 0; i < n; i++) {
            num[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int t = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m-2; j++) {
                if (t <= getMedian(i, j)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static int getMedian(int r, int c) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = r; i < r+3; i++) {
            for (int j = c; j < c+3; j++) {
                numbers.add(num[i][j]);
            }
        }
        Collections.sort(numbers);
        return numbers.get(4);
    }
}
