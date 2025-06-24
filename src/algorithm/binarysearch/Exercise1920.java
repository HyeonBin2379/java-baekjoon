package algorithm.binarysearch;

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
        while (m-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            bw.write(binarySearch(n, num) + "\n");
        }
        br.close();
        bw.close();
    }

    private static int binarySearch(int len, int target) {
        int left = 0;
        int right = len-1;

        while (left <= right) {
            int mid = (left+right) / 2;

            if (arr[mid] == target){
                return 1;
            } else if (arr[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return 0;
    }
}
