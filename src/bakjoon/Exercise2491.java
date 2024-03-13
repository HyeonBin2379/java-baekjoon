package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2491 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] inc = new int[len];
        int[] dec = new int[len];
        Arrays.fill(inc, 1);
        Arrays.fill(dec, 1);
        for (int i = 1; i < len; i++) {
            inc[i] += (num[i] >= num[i-1]) ? inc[i-1] : 0;
            dec[i] += (num[i] <= num[i-1]) ? dec[i-1] : 0;
        }
        int max1 = Arrays.stream(inc).max().getAsInt();
        int max2 = Arrays.stream(dec).max().getAsInt();
        System.out.println(Math.max(max1, max2));
    }
}
