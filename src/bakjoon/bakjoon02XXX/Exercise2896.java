package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise2896 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] juice = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] percentage = new double[3];
        double[] need = new double[3];
        double min = Double.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            percentage[i] = Double.parseDouble(st.nextToken());
            need[i] = juice[i] / percentage[i];
            min = Math.min(need[i], min);
        }

        for (int i = 0; i < 3; i++) {
            System.out.printf("%.4f ", juice[i]-min*percentage[i]);
        }
    }
}
