package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise31535 {

    private static int[] a, p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        p = new int[n+1];
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            // 출발점에서의 수직이동거리 + 도착 직전 수직이동거리 + 수평 이동 거리
            // 위쪽레인->도착점 이동 거리 = 출발~위쪽 레인 간 수직거리 - 출발~도착점 간 수직거리
            // 레인별 밀도로 인해 최단 경로에서 아래로 이동하는 루트 발생(아래의 식은 아래쪽으로 꺾는 루트와 일반적인 최단경로 모두 커버)
            int now = moveVertical(n, a[i-1]) + Math.abs(moveVertical(n, a[i-1]) - moveVertical(n, d)) + (w * p[i]);
            minDist = Math.min(minDist, now);
        }
        System.out.println(minDist);
    }

    private static int moveVertical(int n, int y) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            // 도착 지점의 y좌표가 현재 레일에 해당되는 구간 안에 있는 경우
            if (y < a[i]) {
                res += (y - a[i - 1]) * p[i];
                break;
            }
            // 도착할 지점의 y좌표가 현재 레일에 해당되는 구간 밖에 있는 경우
            res += (a[i] - a[i - 1]) * p[i];
        }
        return res;
    }
}
