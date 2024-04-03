package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise21105 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double p = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());
            double o = p*100/(c+100);
            System.out.printf("%.5f\n", o);
        }
    }
}
