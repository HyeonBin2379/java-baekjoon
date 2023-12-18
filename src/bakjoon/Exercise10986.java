package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // n, m 입력 받기
        int len = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());
        int[] original = new int[len+1];
        int[] prefixSum = new int[len+1];
        int[] counts = new int[div];
        long answer = 0;

        // 원본 수열 저장 배열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < original.length; i++) {
            original[i] = Integer.parseInt(st.nextToken());
        }

        // 합 배열 저장
        // 합 배열을 M으로 나눈 나머지 값으로 갱신, 나머지가 0이면 정답에 누적
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = (prefixSum[i-1] % div) + (original[i] % div);
            int remainder = prefixSum[i] % div;
            if (remainder == 0) {
                answer++;
            }
            counts[remainder]++;
        }
        // 같은 나머지인 인덱스 2개를 뽑는 경우의 수를 정답에 누적
        for (int count : counts) {
            if (count > 1) {
                answer += (long) count * (count - 1) / 2;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
