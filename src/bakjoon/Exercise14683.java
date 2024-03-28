package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise14683 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        a = Math.abs(c-a);
        b = Math.abs(d-b);

        if (a + b > t) {    // 에너지 부족
            System.out.println("N");
        } else if (a + b == t || (t -(a+b)) % 2 == 0) {
            // 마지막 지점 도착 후 왕복으로 에너지 소진 시 마지막 위치가 목표 지점
            System.out.println("Y");
        } else {
            // 마지막 지점 도착해도 왕복으로 에너지 소진 시 도착점 != 목표지점
            System.out.println("N");
        }
    }
}
