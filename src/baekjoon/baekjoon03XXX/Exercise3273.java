package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ", length)).mapToInt(Integer::parseInt).toArray();
        int sum = Integer.parseInt(br.readLine());
        br.close();

        int count = 0;
        int start = 0, end = length - 1;
        Arrays.sort(num);
        while (start < end) {
            if (num[start]+num[end] == sum) {
                count++;
                start++;
                end--;
            } else if (num[start] + num[end] < sum) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(count);
    }
}
