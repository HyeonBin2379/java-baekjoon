package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise30349 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] targetSize = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] wind = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int minPenalty = Integer.MAX_VALUE;
        // 발사 구멍의 영역 안에서 쏜 화살이 목표물의 영역에 존재하는지 확인하고, 이때의 최소 벌점 계산
        // 바람의 방향으로 인해 화살이 도달하는 위치가 변경됨
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int targetX = i + wind[0];
                int targetY = j + wind[1];

                // 화살이 목표물에 명중했을 경우
                if (targetX >= 0 && targetX < targetSize[0] && targetY >= 0 && targetY < targetSize[1]) {
                    minPenalty = Math.min(targetX+targetY, minPenalty);
                }
            }
        }
        System.out.println(minPenalty == Integer.MAX_VALUE ? "NEPATAIKYS" : minPenalty);
    }
}
