package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise15593 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] shifts = new int[n][];
        for (int i = 0; i < n; i++) {
            shifts[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int coveredTime = countCoveredTime(shifts, i, n);
            answer = Math.max(answer, coveredTime);
        }
        System.out.println(answer);
    }

    private static int countCoveredTime(int[][] shifts, int excluded, int n) {
        boolean[] visited = new boolean[1001];
        for (int i = 0; i < n; i++) {
            if (i == excluded) {
                continue;
            }
            IntStream.rangeClosed(shifts[i][0], shifts[i][1]-1).forEach(idx -> visited[idx] = true);
        }
        return (int) IntStream.rangeClosed(0, 1000).filter(idx -> visited[idx]).count();
    }
}
