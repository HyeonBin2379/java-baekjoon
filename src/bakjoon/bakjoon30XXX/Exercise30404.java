package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise30404 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] quack = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 최대한 늦게 박수치는 것이 좋으므로 마지막 오리 소리부터 시작
        int lastClapped = quack[n-1];   // 마지막으로 박수쳐준 오리 소리
        int count = 1;                  // 마지막 꽥꽥에서 박수쳤으므로 1부터 카운트
        for (int i = n-2; i >= 0; i--) {
            // 박수쳐줘야 하는 오리 소리인 경우
            if (lastClapped > quack[i]+k) {
                lastClapped = quack[i];
                count++;
            }
        }
        System.out.println(count);
    }
}
