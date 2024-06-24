package bakjoon.bakjoon2XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[9];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = sc.nextInt();
        }

        Arrays.sort(heights);
        int sum = Arrays.stream(heights).sum();
        int num1 = 0, num2 = 0;
        for (int i = 0; i < heights.length-1; i++) {
            for (int j = i+1; j < heights.length; j++) {
                if (heights[i]+heights[j] == sum-100) {
                    num1 = heights[i];
                    num2 = heights[j];
                    break;
                }
            }
            if (sum - num1 - num2 == 100) {
                break;
            }
        }

        for (int height : heights) {
            if (height != num1 && height != num2) {
                System.out.println(height);
            }
        }
    }
}
