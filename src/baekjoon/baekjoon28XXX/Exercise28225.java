package baekjoon.baekjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise28225 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        double[] neededTime = new double[n];
        double min = Double.MAX_VALUE;
        int answer = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            neededTime[i] = (double)(f-x)/v;
            if (min > neededTime[i]) {
                min = neededTime[i];
                answer = i+1;
            }
        }
        System.out.println(answer);
    }
}
