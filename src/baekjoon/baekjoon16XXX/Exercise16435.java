package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise16435 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] height = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(height);
        for (int i = 0; i < n; i++) {
            if (l >= height[i]) {
                l++;
            }
        }
        System.out.println(l);
    }
}
