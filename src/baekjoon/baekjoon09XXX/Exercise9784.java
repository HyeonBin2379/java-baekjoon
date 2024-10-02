package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise9784 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[] eggs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            int sum = 0;
            int eggCnt = n;
            for (int j = 0; j < eggs.length; j++) {
                if (sum + eggs[j] > q) {
                    eggCnt = j;
                    break;
                }
                sum += eggs[j];
            }
            sb.append(String.format("Case %d: %d\n", i, Math.min(eggCnt, p)));
        }
        System.out.print(sb);
    }
}
