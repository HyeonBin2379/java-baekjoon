package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise9611 {

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] pos = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pos[i] = new Point(x, y);
        }
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken());

            int count = 0;
            for (int j = 0; j < n; j++) {
                if (j == index) {
                    continue;
                }
                int xDiff = Math.abs(pos[j].x-pos[index].x);
                int yDiff = Math.abs(pos[j].y-pos[index].y);
                if (Double.compare(Math.sqrt(xDiff*xDiff + yDiff*yDiff), v) <= 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
