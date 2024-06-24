package bakjoon.bakjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise13251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int colorCount = Integer.parseInt(br.readLine());
        int[] stones = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int totalCount = 0;
        for (int i = 0; i < colorCount; i++) {
            totalCount += stones[i];
        }
        int K = Integer.parseInt(br.readLine());
        br.close();

        double[] probability = new double[colorCount];
        double answer = 0;
        for (int i = 0; i < colorCount; i++) {
            if (stones[i] >= K) {
                probability[i] = 1;
                for (int j = 0; j < K; j++) {
                    probability[i] = probability[i] * (stones[i]-j)/(totalCount-j);
                }
                answer += probability[i];
            }
        }
        System.out.println(answer);
    }
}
