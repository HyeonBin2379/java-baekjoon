package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise25527 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int[] values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = 0;
            for (int i = 1; i < n-1; i++) {
                if (values[i] > values[i-1] && values[i] > values[i+1]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
