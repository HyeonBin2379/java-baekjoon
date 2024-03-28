package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14039 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] num = new int[4][4];
        for (int i = 0; i < 4; i++) {
            num[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int sum = Arrays.stream(num[0]).sum();
        for (int i = 0; i < 4; i++) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < 4; j++) {
                rowSum += num[i][j];
                colSum += num[j][i];
            }
            if (rowSum != sum || colSum != sum) {
                System.out.println("not magic");
                return;
            }
        }
        System.out.println("magic");
    }
}
