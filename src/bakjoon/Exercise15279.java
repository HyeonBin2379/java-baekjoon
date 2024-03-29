package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise15279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            double p = Double.parseDouble(st.nextToken());
            double bpm = 60*b/p;
            System.out.printf("%.4f %.4f %.4f\n", bpm*(1-1.0/b), bpm, bpm*(1+1.0/b));
        }
    }
}
