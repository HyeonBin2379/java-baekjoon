package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise1068 {
    private static final List<List<Integer>> tree = new ArrayList<>();
    private static boolean[] visited;
    private static int answer, root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        visited = new boolean[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            tree.add(new ArrayList<>());
        }

        int[] nodes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == -1) {
                root = i;
            } else {
                tree.get(i).add(nodes[i]);
                tree.get(nodes[i]).add(i);
            }
        }

        int deleteNode = Integer.parseInt(br.readLine());
        if (deleteNode != root) {
            dfs(root, deleteNode);
        }
        System.out.println((deleteNode != root) ? answer : 0);
        br.close();
    }

    public static void dfs(int currNode, int deleteNode) {
        visited[currNode] = true;
        int childNodeCount = 0;
        for (Integer nextNode : tree.get(currNode)) {
            if (!visited[nextNode] && nextNode != deleteNode) {
                childNodeCount++;
                dfs(nextNode, deleteNode);
            }
        }
        if (childNodeCount == 0) {
            answer++;
        }
    }
}
