package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise10816 {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).sorted().toArray();

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int target = Integer.parseInt(st.nextToken());
            int left = lowerIndex(n, target);
            int right = upperIndex(n, target);
            bw.write((right-left) + " ");
        }
        br.close();
        bw.close();
    }

    // 인덱스 범위의 시작값 탐색
    private static int lowerIndex(int size, int target) {
        int left = 0;
        int right = size;

        while (left < right) {
            int mid = (left+right) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    // 인덱스 범위의 끝값 탐색
    private static int upperIndex(int size, int target) {
        int left = 0;
        int right = size;

        while (left < right) {
            int mid = (left+right) / 2;

            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}
