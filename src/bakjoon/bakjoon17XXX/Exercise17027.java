package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise17027 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] swapLog = new int[n][3];
        for (int i = 0; i < n; i++) {
            swapLog[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int answer = 0;
        for (int i = 0; i < 3; i++) {
            boolean[] cup = new boolean[3];
            cup[i] = true;

            int count = 0;
            for (int j = 0; j < n; j++) {
                int swapA = swapLog[j][0]-1;
                int swapB = swapLog[j][1]-1;
                int choose = swapLog[j][2]-1;

                boolean temp = cup[swapA];
                cup[swapA] = cup[swapB];
                cup[swapB] = temp;

                if (cup[choose]) {
                    count++;
                }
            }
            answer = Math.max(count, answer);
        }
        System.out.println(answer);
    }
}
