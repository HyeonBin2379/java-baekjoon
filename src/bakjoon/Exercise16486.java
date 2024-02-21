package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise16486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long d1 = Long.parseLong(br.readLine());
        long d2 = Long.parseLong(br.readLine());
        br.close();

        double result = (d1 + 3.141592*d2)*2;
        System.out.printf("%.6f\n", result);
    }
}
