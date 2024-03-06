package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise30216 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = 0, count = 0;
        for (int i = 1; i < len; i++) {
            count += (num[i] > num[i-1]) ? 1 : -count;
            max = Math.max(max, count);
        }
        System.out.println(max+1);
    }
}
