package bakjoon.bakjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise29627 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] replacingTime = new int[n+2];    // 00:00~23:59 사이 배터리 교체 시간을 분 단위로 환산
        for (int i = 1; i <= n; i++) {
            replacingTime[i] = Arrays.stream(br.readLine().split(":"))
                    .mapToInt(Integer::parseInt)
                    .reduce(0, (a, b) -> a*60 + b);
        }
        replacingTime[n+1] = 1439; // 23:59

        double answer = 100.0;  // 처음에는 완전히 충전된 배터리를 사용, 이후는 사용-충전-사용-...의 반복
        for (int i = 1; i <= n+1; i++) {
            double temp = 100.0*(replacingTime[i]-replacingTime[i-1]);
            answer = (i % 2 == 1) ? Math.min(100.0, answer + temp/y) : Math.max(0.0, answer - temp/x);
        }
        System.out.printf("%.3f\n", answer);
    }
}
