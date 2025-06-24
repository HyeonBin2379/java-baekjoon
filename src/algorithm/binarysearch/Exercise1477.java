package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1477 {

    private static int[] stop;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        stop = new int[n+2];
        stop[n+1] = l;
        if (n > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                stop[i] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(stop);

        System.out.println(upperBound(l, m));
    }

    private static int upperBound(int right, int needed) {
        int left = 1;

        while (left <= right) {
            int mid = (left+right)/2;
            int count = 0;
            for (int i = 1; i < stop.length; i++) {
                // 이미 휴게소가 있는 지점을 제외한 나머지 구간에 둘 수 있는 휴게소의 개수
                count += (stop[i]-stop[i-1]-1)/mid;
            }

            if (count > needed) {
                // 현재 mid 값이 너무 작아서 dist의 길이를 증가시켜야 함
                left = mid+1;
            } else {
                // 현재 mid 값이 너무 커서 dist의 길이를 감소시켜야 함
                right = mid-1;
            }
        }
        return left;
    }
}
