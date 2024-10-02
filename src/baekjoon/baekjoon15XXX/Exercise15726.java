package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise15726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] num = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        int result1 = (int) (num[0]*num[1]/num[2]);
        int result2 = (int) (num[0]/num[1]*num[2]);
        System.out.println(Math.max(result1, result2));
    }
}
