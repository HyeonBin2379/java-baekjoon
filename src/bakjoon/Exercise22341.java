package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise22341 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int nowX = n, nowY = n;
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (x > nowX || y > nowY) {
                continue;
            }

            int nextX = nowX, nextY = y;
            if (y*nowX < nowY*x) {
                nextX = x;
                nextY = nowY;
            }
            nowX = nextX;
            nowY = nextY;
        }
        System.out.println(nowX*nowY);
    }
}
