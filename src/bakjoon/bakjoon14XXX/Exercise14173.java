package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14173 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rect1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] rect2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxHeight = Math.max(rect1[3], rect2[3]) - Math.min(rect1[1], rect2[1]);
        int maxWidth = Math.max(rect1[2], rect2[2]) - Math.min(rect1[0], rect2[0]);
        System.out.println((int) Math.pow(Math.max(maxWidth, maxHeight), 2));
    }
}
