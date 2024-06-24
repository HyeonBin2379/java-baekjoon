package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise26849 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] fraction = new double[n];
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            fraction[i] = (double)a/b;
            sum += fraction[i];
        }
        Arrays.sort(fraction);
        System.out.printf("%.6f %.6f %.6f\n", fraction[0], fraction[n-1], sum);
    }
}
