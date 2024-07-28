package bakjoon.bakjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Exercise20186 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        // 입력한 자연수의 크기는 일정, 각 자연수마다 빼는 수의 범위도 0~(k-1)로 일정
        // 선택한 k개의 자연수 합이 최대이면 전체점수는 최대
        long sum = Arrays.stream(br.readLine().split(" ", n))
                .map(Long::parseLong)
                .sorted(Comparator.reverseOrder())
                .limit(k)
                .reduce(0L, Long::sum);
        System.out.println(sum - k*(k-1)/2);
    }
}
