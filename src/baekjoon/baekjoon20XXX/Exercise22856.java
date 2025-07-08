package baekjoon.baekjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise22856 {

    private static final List<Integer> pseudoInorder = new ArrayList<>();

    private static int[] left, right, inorder;
    private static boolean[] visited;
    private static int idx, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        left = new int[n+1];
        right = new int[n+1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            left[cur] = Integer.parseInt(st.nextToken());
            right[cur] = Integer.parseInt(st.nextToken());
        }

        inorder = new int[n];
        inorder(1);

        visited = new boolean[n+1];
        pseudoInorder(1, inorder[n-1], n);
    }

    private static void inorder(int cur) {
        if (left[cur] != -1) {
            inorder(left[cur]);
        }
        inorder[idx++] = cur;
        if (right[cur] != -1) {
            inorder(right[cur]);
        }
    }

    private static void pseudoInorder(int cur, int last, int n) {
        pseudoInorder.add(cur);
        if (!visited[cur]) {
            visited[cur] = true;
            count++;
        }
        if (left[cur] != -1) {
            pseudoInorder(left[cur], last, n);
            pseudoInorder.add(cur);
        }
        if (right[cur] != -1) {
            pseudoInorder(right[cur], last, n);
            pseudoInorder.add(cur);
        }
        if (count == n && cur == last) {
            // 이동 횟수 = 방문한 정점 개수 - 1
            System.out.println(pseudoInorder.size()-1);
            System.exit(0);
        }
    }
}
