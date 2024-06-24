package bakjoon.bakjoon5XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise5163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            double w = Double.parseDouble(st.nextToken());

            double volume = 0d;
            for (int j = 0; j < b; j++) {
                double balloon = Double.parseDouble(br.readLine());
                volume += Math.PI*Math.pow(balloon, 3)*4/3;
            }
            sb.append(String.format("Data Set %d:\n", i));
            sb.append((volume/1000 >= w) ? "Yes\n\n" : "No\n\n");
        }
        System.out.print(sb);
    }
}
