package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise10180 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
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
