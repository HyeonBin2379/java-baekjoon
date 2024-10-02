package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise32205 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 세모의 개수
        int n = Integer.parseInt(br.readLine());
        // 변의 길이를 저장할 맵
        Map<Integer, Integer> lengthCount = new HashMap<>();

        // 세모의 세 변의 길이를 입력받음
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 각각의 변 길이에 대해 카운트
            lengthCount.put(a, lengthCount.getOrDefault(a, 0) + 1);
            lengthCount.put(b, lengthCount.getOrDefault(b, 0) + 1);
            lengthCount.put(c, lengthCount.getOrDefault(c, 0) + 1);
        }
        br.close();

        // 네모를 만들 수 있는지 확인
        for (int count : lengthCount.values()) {
            if (count >= 2) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}