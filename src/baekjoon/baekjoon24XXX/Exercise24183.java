package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise24183 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] weight = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        weight[0] *= 0.229*0.324*2;
        weight[1] *= 0.297*0.420*2;
        weight[2] *= 0.210*0.297;
        System.out.printf("%.6f\n", Arrays.stream(weight).sum());
    }
}
