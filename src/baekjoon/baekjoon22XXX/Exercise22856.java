package baekjoon.baekjoon22XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise22856 {

    private static int visitedCount, n, lastNode;
    private static boolean[] visited;
    private static Node[] tree;
    private static List<Integer> inorderStatus, pseudoInorderStatus;
    private static class Node {
        int left, right;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new Node[n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree[num] = new Node(left, right);
        }

        inorderStatus = new ArrayList<>();
        inorder(1);
        lastNode = inorderStatus.get(inorderStatus.size()-1);

        pseudoInorderStatus = new ArrayList<>();
        visited = new boolean[n+1];
        visited[0] = true;
        pseudoInorder(1);
    }

    private static void inorder(int now) {
        if (tree[now].left > 0) {
            inorder(tree[now].left);
        }
        inorderStatus.add(now);
        if (tree[now].right > 0) {
            inorder(tree[now].right);
        }
    }

    private static void pseudoInorder(int now) {
        // 현재 위치한 노드 정보를 저장하고 방문 여부 확인: 부모 노드에서 자식 노드로 이동
        Node currNode = tree[now];
        pseudoInorderStatus.add(now);
        if (!visited[now]) {
            visited[now] = true;
            visitedCount++;
        }

        // 현재 위치한 노드의 왼쪽 자식 노드로 이동
        if (currNode.left > 0) {
            pseudoInorder(currNode.left);
            pseudoInorderStatus.add(now);
        }
        // 현재 위치한 노드의 오른쪽 자식 노드로 이동
        if (currNode.right > 0) {
            pseudoInorder(currNode.right);
            pseudoInorderStatus.add(now);
        }
        // 현재 위치한 노드가 중위 순회의 끝
        if (visitedCount == n && now == lastNode) {
            System.out.println(pseudoInorderStatus.size()-1);
            System.exit(0);
        }
    }
}
