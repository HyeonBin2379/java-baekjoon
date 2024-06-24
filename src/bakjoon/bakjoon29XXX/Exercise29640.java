package bakjoon.bakjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise29640 {

    private static class Pair implements Comparable<Pair> {
        int x, y, dist;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = (x*x) + (y*y);
        }

        @Override
        public int compareTo(Pair o) {
            if (this.dist != o.dist) {
                return this.dist - o.dist;
            } else {
                if (this.x != o.x) {
                    return this.x-o.x;
                } else {
                    return this.y-o.y;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] result = {0, 0};
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            Pair[] a = new Pair[m];
            Pair[] b = new Pair[k];
            for (int j = 0; j < m+k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (j < m) {
                    a[j] = new Pair(x, y);
                } else {
                    b[j-m] = new Pair(x, y);
                }
            }
            Arrays.sort(a);
            Arrays.sort(b);

            for (int j = 0; j < m; j++) {
                result[0] += (a[j].dist < b[0].dist) ? 1 : 0;
            }
            for (int j = 0; j < k; j++) {
                result[1] += (b[j].dist < a[0].dist) ? 1 : 0;
            }
        }
        System.out.printf("%d:%d\n", result[0], result[1]);
    }
}