package bakjoon.bakjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise21280 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int emptyClass = 0;
        int missed = 0;
        for (int i = 1; i < n; i++) {
            if (num[i-1] < num[i]) {
                missed += (num[i]-num[i-1]);
            } else if (num[i-1] > num[i]) {
                emptyClass += (num[i-1]-num[i]);
            }
        }
        System.out.println(emptyClass + " " + missed);
    }
}
