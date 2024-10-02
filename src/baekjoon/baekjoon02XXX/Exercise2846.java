package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Exercise2846 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] height = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> uphill = new ArrayList<>();
        int h = 0;
        for (int i = 0; i < n; i++) {
            if (i == n-1) {
                uphill.add(h);
            } else if (height[i] < height[i+1]) {
                h += height[i+1]-height[i];
            } else {
                uphill.add(h);
                h = 0;
            }
        }
        System.out.println(uphill.stream().max(Comparator.comparingInt(o -> o)).get());
    }
}
