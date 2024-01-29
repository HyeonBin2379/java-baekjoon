package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise11725 {
    private static final List<List<Integer>> tree = new ArrayList<>();
    private static boolean[] visited;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < nodeCount; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < nodeCount-1; i++) {
            int[] parentAndChild = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            tree.get(parentAndChild[0]-1).add(parentAndChild[1]-1);
            tree.get(parentAndChild[1]-1).add(parentAndChild[0]-1);
        }
        br.close();

        answer = new int[nodeCount];
        visited = new boolean[nodeCount];
        dfs(0);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < nodeCount; i++) {
            bw.write(answer[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int start) {
        visited[start] = true;
        for (Integer nextNode : tree.get(start)) {
            if (!visited[nextNode]) {
                answer[nextNode] = start+1;
                dfs(nextNode);
            }
        }
    }
}
