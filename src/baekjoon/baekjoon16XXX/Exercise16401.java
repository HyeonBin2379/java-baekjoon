package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise16401 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int left = 1, right = num[n-1];
        int answer = 0;
        while (left <= right) {
            int mid = (left+right)/2;
            int count = Arrays.stream(num).map(length -> length/mid).sum();
            if (count >= m) {
                answer = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        System.out.println(answer);
    }
}
