package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise29538 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int[] mass = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).toArray();

        double low = 0, high = 1e9;
        double result = -1;
        while (high - low > 1e-6) {
            double mid = (low + high) / 2;
            double total = m + Arrays.stream(mass).sum() + mid;

            if (mid >= a*total/1000) {
                result = mid;
                high = mid;
            } else {
                low = mid;
            }
        }
        System.out.println(result == -1 ? "Impossible" : String.format("%.6f", result));
    }
}
