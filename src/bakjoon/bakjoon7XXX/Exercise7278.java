package bakjoon.bakjoon7XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise7278 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] blocks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] height = new int[3];

        int minIndex = -1;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int diff1 = Math.abs(n-blocks[i]*(n/blocks[i]));
            int diff2 = Math.abs(n-blocks[i]*(n/blocks[i]+1));

            height[i] = (diff1 <= diff2) ? blocks[i]*(n/blocks[i]) : blocks[i]*(n/blocks[i]+1);
            int temp = Math.abs(n-height[i]);
            if (temp < minDiff) {
                minDiff = temp;
                minIndex = i;
            } else if (temp == minDiff) {
                minIndex = Math.min(i, minIndex);
            }
        }
        System.out.println(blocks[minIndex] + " " + height[minIndex]);
    }
}
