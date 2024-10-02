package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise30891 {

    private static int n, r;
    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static final List<Point> input = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            input.add(new Point(x, y));
        }
        input.sort((o1, o2) -> o1.x == o2.x ? Integer.compare(o1.y, o2.y) : Integer.compare(o1.x, o2.x));

        int maxCnt = 0;
        String answer = "";
        for (int i = -100; i <= 100; i++) {
            for (int j = -100; j <= 100; j++) {
                int count = countPoint(new Point(i, j));
                if (maxCnt < count) {
                    maxCnt = count;
                    answer = String.format("%d %d", i, j);
                }
            }
        }
        System.out.println(answer);
    }

    private static int countPoint(Point a) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int w = Math.abs(a.x-input.get(i).x);
            int h = Math.abs(a.y-input.get(i).y);
            if (r*r >= w*w + h*h) {
                count++;
            }
        }
        return count;
    }
}
