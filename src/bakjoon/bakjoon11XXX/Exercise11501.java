package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise11501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] stockPrice = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

            long result = 0;
            int j = n-1;
            for (int i = n-2; i >= 0; i--) {
                if (stockPrice[j] > stockPrice[i]) {
                    result += (stockPrice[j] - stockPrice[i]);
                } else {
                    j = i;
                }
            }
            System.out.println(result);
        }
    }
}
