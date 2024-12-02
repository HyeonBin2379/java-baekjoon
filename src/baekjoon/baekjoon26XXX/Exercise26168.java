package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise26168 {

    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ", n)).mapToLong(Long::parseLong).sorted().toArray();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int category = Integer.parseInt(st.nextToken());
            long num = Long.parseLong(st.nextToken());

            int count;
            switch (category) {
                case 1 -> {
                    count = n - lowerBound(num);
                    bw.write(count + "\n");
                }
                case 2 -> {
                    count = n - upperBound(category, num);
                    bw.write(count + "\n");
                }
                case 3 -> {
                    long num2 = Long.parseLong(st.nextToken());
                    int count2 = upperBound(category, num2);
                    count = lowerBound(num);
                    bw.write((count2 - count + 1) + "\n");
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static int lowerBound(long target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left+right)/2;

            if (target <= arr[mid]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    private static int upperBound(int category, long target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left+right)/2;

            if (target >= arr[mid]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return (category == 2) ? left : left-1;
    }
}
