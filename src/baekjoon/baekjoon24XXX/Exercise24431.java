package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise24431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            String[] arr = br.readLine().split(" ", n);

            // 길이가 f인 접미사와 그 개수 저장
            Map<String, Integer> map = new HashMap<>();
            for (String str : arr) {
                String subStr = str.substring(l-f);
                map.merge(subStr, 1, Integer::sum);
            }

            // 2회 이상 등장한 접미사일 경우 생성되는 쌍의 개수 구하기
            int answer = 0;
            for (int cnt : map.values()) {
                if (cnt >= 2) {
                    answer += cnt/2;
                }
            }
            System.out.println(answer);
        }
    }
}
