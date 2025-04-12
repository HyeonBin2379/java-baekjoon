package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1920 {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        while (m-- > 0) {
            int target = Integer.parseInt(st.nextToken());
            if (containsNum(n, target)) {
                bw.write(1 +"\n");
            } else {
                bw.write(0 + "\n");
            }
        }
        bw.close();
    }

    private static boolean containsNum(int len, int target) {
        int left = 0;
        int right = len-1;

        while (left <= right) {
            int mid = (left + right)/2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }
}
