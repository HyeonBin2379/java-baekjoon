package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise29752 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = 0, continuous = 0;
        for (int i = 0; i < len; i++) {
            if (num[i] == 0) {
                max = Math.max(continuous, max);
                continuous = 0;
            } else {
                continuous++;
            }
        }
        max = Math.max(continuous, max);
        System.out.println(max);
    }
}
