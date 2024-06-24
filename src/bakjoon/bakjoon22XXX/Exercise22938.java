package bakjoon.bakjoon22XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise22938 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] c1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] c2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        double sum = c1[2]+c2[2];
        double dist = Math.sqrt(Math.pow(Math.abs(c1[0]-c2[0]), 2) + Math.pow(Math.abs(c1[1]-c2[1]), 2));
        System.out.println(Double.compare(dist, sum) >= 0 ? "NO" : "YES");
    }
}
