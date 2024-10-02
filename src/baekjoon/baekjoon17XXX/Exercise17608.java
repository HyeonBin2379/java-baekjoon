package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise17608 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] height = new int[size];
        for (int i = 0; i < size; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int max = 0;
        for (int i = size-1; i >= 0; i--) {
            if (height[i] > max) {
                max = height[i];
                count++;
            }
        }
        System.out.println(count);
    }
}
