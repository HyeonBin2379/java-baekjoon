package baekjoon.baekjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise23663 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] red = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).toArray();
            int[] white = Arrays.stream(br.readLine().split(" ", m)).mapToInt(Integer::parseInt).toArray();
            sb.append(n > m ? "No\n" : "Yes\n");
        }
        System.out.print(sb);
    }
}
