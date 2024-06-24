package bakjoon.bakjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise29667 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] score = new int[2][2];
        for (int i = 0; i < 2; i++) {
            score[i] = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        }

        if (score[0][0] >= score[1][0] && score[0][1] >= score[1][1]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
