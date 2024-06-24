package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1456 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());
        long[] num = new long[10000001];
        for (int i = 2; i < num.length; i++) {
            num[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(num.length); i++) {
            if (num[i] == 0) {
                continue;
            }
            for (int j = i+i; j < num.length; j += i) {
                num[j] = 0;
            }
        }

        int count = 0;
        for (int i = 2; i < 10000001; i++) {
            if (num[i] != 0) {
                long temp = num[i];
                while ((double)num[i] <= (double)end/temp) {
                    if ((double)num[i] >= (double)start/temp) {
                        count++;
                    }
                    temp = temp * num[i];
                }
            }
        }
        System.out.println(count);
    }
}
