package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise29615 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] queue = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> friend = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .toList();
        int answer = 0;
        for (int i = 0; i < m; i++) {
            if (!friend.contains(queue[i])) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
