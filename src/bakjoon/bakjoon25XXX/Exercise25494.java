package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Exercise25494 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bw.write(getCount(num) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static int getCount(int[] num) {
        int count = 0;
        for (int i = 1; i <= num[0]; i++) {
            for (int j = 1; j <= num[1]; j++) {
                for (int k = 1; k <= num[2]; k++) {
                    if ((i % j) == (j % k) && (j % k) == (k % i)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
