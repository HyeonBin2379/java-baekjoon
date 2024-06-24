package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise30804 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] fruit = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] count = new int[10];

        int right;
        int left = 0, max = 0, kind = 0;
        for (right = 0; right < n; right++) {
            // 과일 개수가 최대이려면 매 반복마다 오른쪽에 과일 추가
            ++count[fruit[right]];
            if (count[fruit[right]] == 1) {
                ++kind;
            }

            // 과일 종류가 2개 이하가 될 때까지 왼쪽에서 과일 제거
            while (kind > 2) {
                --count[fruit[left]];
                if (count[fruit[left]] == 0) {
                    --kind;
                }
                left++;
            }

            // 현재 과일 종류가 2개 이하일 때, 과일 개수의 최대값 구하기
            max = Math.max(max, right-left+1);
        }
        System.out.println(max);
    }
}
