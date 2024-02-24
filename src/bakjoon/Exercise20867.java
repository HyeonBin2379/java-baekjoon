package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise20867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] msg = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double[] ab = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        int[] lr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        double left = Math.ceil((double) msg[0] / msg[2]) + lr[0] /ab[0];
        double right = Math.ceil((double) msg[0] / msg[1]) + lr[1] /ab[1];
        System.out.println((left < right) ? "friskus" : "latmask");
    }
}
