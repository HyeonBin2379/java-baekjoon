import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exercise1717 {
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int operationCount = Integer.parseInt(st.nextToken());

        parent = new int[nodeCount+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < operationCount; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                union(nodeA, nodeB);
            }
            else {
                bw.write(checkSame(nodeA, nodeB) ? "YES" : "NO");
                bw.write("\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static void union(int nodeA, int nodeB) {
        int rootA = find(nodeA);
        int rootB = find(nodeB);
        if (rootA != rootB) {
            parent[rootA] = Math.min(rootA, rootB);
            parent[rootB] = parent[rootA];
        }
    }
    public static int find(int node) {
        return (node == parent[node]) ? node : (parent[node] = find(parent[node]));
    }
    public static boolean checkSame(int nodeA, int nodeB) {
        int rootA = find(nodeA);
        int rootB = find(nodeB);
        return rootA == rootB;
    }
}
