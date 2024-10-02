package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Exercise11257 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum = Arrays.stream(data).sum() - data[0];
            bw.write(String.format("%d %d ", data[0], sum));
            bw.write((sum >= 55 && isOver(data)) ? "PASS\n" : "FAIL\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean isOver(int[] data) {
        double[] limit = {35*0.3, 25*0.3, 40*0.3};
        for (int i = 1; i < 4; i++) {
            if ((double)data[i] < limit[i-1]) {
                return false;
            }
        }
        return true;
    }
}
