package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise10708 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 친구 수
        int m = Integer.parseInt(br.readLine());    // 게임 횟수
        int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] totalScore = new int[n];
        for (int i = 0; i < m; i++) {
            int[] expected = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int incorrect = 0;
            for (int j = 0; j < n; j++) {
                if (target[i] == expected[j]) {
                    totalScore[j]++;
                } else {
                    incorrect++;
                }
            }
            totalScore[target[i]-1] += incorrect;
        }
        Arrays.stream(totalScore).forEach(System.out::println);
    }
}
