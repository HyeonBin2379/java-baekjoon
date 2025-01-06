package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise32626 {

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static Point[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new Point[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Point(x, y);
        }
        swap();

        if (Arrays.stream(arr).allMatch(point -> point.x == arr[0].x) && (arr[0].y < arr[1].y && arr[1].y < arr[2].y || arr[2].y < arr[1].y && arr[1].y < arr[0].y)
                || Arrays.stream(arr).allMatch(point -> point.y == arr[0].y) && (arr[0].x < arr[1].x && arr[1].x < arr[2].x || arr[2].x < arr[1].x && arr[1].x < arr[0].x)) {
            System.out.println(2);
        } else if (arr[0].x == arr[2].x || arr[0].y == arr[2].y) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }

    private static void swap() {
        Point temp = arr[1];
        arr[1] = arr[2];
        arr[2] = temp;
    }
}
