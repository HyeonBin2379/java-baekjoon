package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise10216 {

    static class Circle {
        int x, y, r;

        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Circle[] circles = new Circle[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                circles[i] = new Circle(x, y, r);
            }

            parent = IntStream.range(0, n).toArray();
            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j < n; j++) {
                    Circle c1 = circles[i];
                    Circle c2 = circles[j];

                    if (find(i) == find(j)) {
                        continue;
                    }

                    int range = (int) Math.pow(c1.r+c2.r, 2);
                    int dis =  (int) (Math.pow(c1.x-c2.x, 2)+Math.pow(c1.y-c2.y, 2));
                    if (range >= dis) {
                        union(i, j);
                    }
                }
            }
            System.out.println(IntStream.range(0, n).filter(idx -> parent[idx] == idx).count());
        }
    }

    private static int find(int curr) {
        if (parent[curr] == curr) {
            return curr;
        }
        return parent[curr] = find(parent[curr]);
    }

    private static void union(int a, int b) {
        int g1 = find(a);
        int g2 = find(b);

        if (parent[g1] < parent[g2]) {
            parent[g2] = g1;
        } else {
            parent[g1] = g2;
        }
    }
}
