package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;

public class Exercise14921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int left = 0, right = n-1;
        int answer = Integer.MAX_VALUE;
        while (left < right) {
            int sum = values[left] + values[right];
            if (Math.abs(answer) > Math.abs(sum)) {
                answer = sum;
                if (sum == 0) {
                    break;
                }
            }
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(answer);
    }
}
