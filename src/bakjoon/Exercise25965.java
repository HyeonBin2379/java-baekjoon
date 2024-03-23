package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise25965 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int m = Integer.parseInt(br.readLine());
            long[][] kda = new long[m][3];

            for (int j = 0; j < m; j++) {
                kda[j] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            }
            long[] sb = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long total = 0;
            for (int j = 0; j < m; j++) {
                total += Math.max(kda[j][0]*sb[0] - kda[j][1]*sb[1] + kda[j][2]*sb[2], 0);
            }
            System.out.println(total);
        }
    }
}
