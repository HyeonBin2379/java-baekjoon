package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ", n)).mapToLong(Long::parseLong).sorted().toArray();
        int m = Integer.parseInt(br.readLine());

        // 주어진 전체 예산에서 가능한 최대의 상한액 찾기
        long start = 1, end = arr[n-1];
        long answer = 0;
        while (start <= end) {
            long mid = (start+end) / 2;
            long total = Arrays.stream(arr).map(budget -> Math.min(budget, mid)).sum();
            if (m >= total) {
                answer = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        System.out.println(answer);
    }
}
