package bakjoon.bakjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise32141 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long h = Long.parseLong(st.nextToken());
        long[] power = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        int count = 0;
        for (int i = 0; i < n; i++) {
            h -= power[i];
            count++;
            if (h <= 0) {
                System.out.println(count);
                return;
            }
        }
        System.out.println(-1);
    }
}
