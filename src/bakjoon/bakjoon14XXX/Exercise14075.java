package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            if (i % 2 == 0) {
                num[i] *= 2;
                if (num[i] > 9) {
                    int[] temp = Arrays.stream(Integer.toString(num[i]).split(""))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    num[i] = Arrays.stream(temp).sum();
                }
            }
            sum += num[i];
        }
        System.out.println(sum % 10 == 0 ? "DA" : "NE");
    }
}
