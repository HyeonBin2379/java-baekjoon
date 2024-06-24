package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise30260 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int n = Integer.parseInt(st.nextToken());
            int[] p = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).toArray();

            int count = 1;
            int now = l;
            while (p[now] != 0) {
                now = p[now]-1;
                count++;
            }
            sb.append(String.format("Data Set %d:\n%d\n\n", i, count));
        }
        System.out.print(sb);
    }
}
