package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise17087 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());   // 시작 지점
        int d = 0;                                      // 아직 최대공약수 d를 못 구한 경우

        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int dest = Integer.parseInt(st.nextToken());   // 동생 위치(목적지)
            int dist = Math.abs(start-dest);
            d = gcd(dist, d);
        }
        System.out.println(d);
    }

    // d를 여러 번 빼는 것은 곧 d로 나누는 것과 동일,
    // 즉 각기 다른 동생의 위치에서 내 위치를 빼서 구한 각각의 거리의 최대공약수를 구한다
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
