package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise17450 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] name = {"S", "N", "U"};
        double[] result = new double[3];
        double max = 0.0;
        int answer = 0;

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken())*10;
            int weight = Integer.parseInt(st.nextToken())*10;

            cost -= (cost >= 5000) ? 500 : 0;
            result[i] = (double) weight / cost;
            if (max < result[i]) {
                max = result[i];
                answer = i;
            }
        }
        System.out.println(name[answer]);
    }
}
