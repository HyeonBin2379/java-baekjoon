package bakjoon.bakjoon4XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise4454 {

    private static double[] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            data = Arrays.stream(input.split(" ")).mapToDouble(Double::parseDouble).toArray();
            int left = 1, right = 1000000;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (getUsedOil(mid/1000.0)*data[4] <= data[5]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            double answer = ((int)(100*right/1000.0))/100.0;
            System.out.printf("%.2f\n", answer);
        }
    }

    private static double getUsedOil(double speed) {
        double result = 0;
        for (int i = 0; i < 4; i++) {
            result += data[i]*Math.pow(speed, 3-i);
        }
        return result;
    }
}
