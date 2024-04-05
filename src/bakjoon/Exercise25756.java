package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise25756 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        double v = 0.0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            double newV = 1-(1-v)*(1-a/100.0);
            System.out.printf("%.6f\n", newV*100);
            v = newV;
        }
    }
}
