package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] range = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        int result = 0;
        for (int i = 1; i < range[1]+1; i++) {
            for (int j = 1; j < i+1; j++) {
                count++;
                if (range[0] <= count && count <= range[1]) {
                    result += i;
                }
            }
        }
        System.out.println(result);
    }
}
