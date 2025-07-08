package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise20955 {

    private static int[] parent;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = IntStream.rangeClosed(0, n).toArray();

        // 연결하는 것과 끊는 것 모두 연산 횟수에 포함
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (find(a) != find(b)) {
                union(a, b);
            } else {
                answer++;
            }
        }
        answer += (int) IntStream.rangeClosed(1, n).filter(idx -> parent[idx] == idx).count();
        System.out.println(answer-1);
    }

    private static int find(int cur) {
        if (parent[cur] == cur) {
            return cur;
        }
        return parent[cur] = find(parent[cur]);
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
