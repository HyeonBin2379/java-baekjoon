package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise2358 {

    private static final Set<Integer> points = new HashSet<>();
    private static final Map<Integer, Integer> xAxis = new HashMap<>();
    private static final Map<Integer, Integer> yAxis = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // x좌표 또는 y좌표의 값으로 지정된 값을 갖는 점의 개수 세기
            xAxis.merge(x, 1, Integer::sum);
            yAxis.merge(y, 1, Integer::sum);

            // x좌표나 y좌표에 사용된 값을 모두 저장: 같은 직선을 여러 번 세는 것을 방지
            points.add(x);
            points.add(y);
        }

        Iterator<Integer> i = points.iterator();
        int answer = 0;
        while (i.hasNext()) {
            int num = i.next();
            // x좌표나 y좌표 중 하나가 동일한, 2개 이상의 점을 지나는 직선의 개수 구하기
            if (xAxis.getOrDefault(num, 0) >= 2) {
                answer++;
            }
            if (yAxis.getOrDefault(num, 0) >= 2) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
