package baekjoon.baekjoon09XXX;

import java.io.*;
import java.util.*;

public class Exercise9501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            double d = Double.parseDouble(st.nextToken());
            int count = 0;
            for (int j = 0; j < n; j++) {
                double[] data = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
                double needTime = d / data[0];
                count += (data[1] >= data[2]*needTime) ? 1 : 0;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
