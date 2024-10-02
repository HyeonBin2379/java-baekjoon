package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2520 {
    private static final double[] dough = {0.5, 0.5, 0.25, 0.0625, 0.5625};
    private static final int[] topping = {1, 30, 25, 10};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] input1 = new int[5];
            int maxDough = Integer.MAX_VALUE;
            for (int j = 0; j < 5; j++) {
                int ingredient = Integer.parseInt(st.nextToken());
                input1[j] = (int) (ingredient / dough[j]);
                maxDough = Math.min(input1[j], maxDough);
            }

            st = new StringTokenizer(br.readLine());
            int[] input2 = new int[4];
            int totalCnt = 0;
            for (int j = 0; j < 4; j++) {
                int menu = Integer.parseInt(st.nextToken());
                input2[j] = menu/topping[j];
                totalCnt += input2[j];
            }
            System.out.println(Math.min(maxDough, totalCnt));
        }
    }
}
