package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise11758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] pos = new int[3][2];
        for (int i = 0; i < 3; i++) {
            pos[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();

        int ccw = (pos[0][0]*pos[1][1] + pos[1][0]*pos[2][1] + pos[2][0]*pos[0][1])
                - (pos[1][0]*pos[0][1] + pos[2][0]*pos[1][1] + pos[0][0]*pos[2][1]);
        if (ccw > 0) {
            System.out.println(1);
        } else if (ccw < 0) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }
    }
}
