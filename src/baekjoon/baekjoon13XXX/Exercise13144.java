package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise13144 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] visited = new boolean[Arrays.stream(num).reduce(0, Integer::max)+1];

        int end = 0;
        long answer = 0;
        for (int start = 0; start < n; start++) {
            while (end < n) {
                if (visited[num[end]]) {
                    break;
                }
                visited[num[end]] = true;
                end++;
            }
            answer += (end-start);
            visited[num[start]] = false;
        }
        System.out.println(answer);
    }
}
