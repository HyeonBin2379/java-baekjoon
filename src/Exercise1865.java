import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise1865 {
    private static class Edge {
        int start, end;
        long time;
        public Edge(int start, int end, long time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
    private static List<Edge> edges;
    private static int nodeCount;
    private static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nodeCount = Integer.parseInt(st.nextToken());
            int edgeCount = Integer.parseInt(st.nextToken());
            int wormHoleCount = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();
            for (int j = 0; j < edgeCount + wormHoleCount; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                if (j < edgeCount) {
                    edges.add(new Edge(from, to, time));
                    edges.add(new Edge(to, from, time));
                } else {
                    edges.add(new Edge(from, to, -time));
                }
            }

            boolean isMinusCycle = false;
            for (int j = 1; j < nodeCount+1; j++) {
                if (bellmanFord(j)) {
                    isMinusCycle = true;
                    sb.append("YES\n");
                    break;
                }
            }
            if (!isMinusCycle) {
                sb.append("NO\n");
            }
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean bellmanFord(int start) {
        long[] distance = new long[nodeCount + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;
        boolean update = false;

        for (int i = 1; i < nodeCount; i++) {
            update = false;
            for (Edge now : edges) {
                if (distance[now.start] != INF && distance[now.end] > distance[now.start] + now.time) {
                    distance[now.end] = distance[now.start] + now.time;
                    update = true;
                }
            }
            if (!update) {
                break;
            }
        }

        if (update) {
            for (Edge now : edges) {
                if (distance[now.start] != INF && distance[now.end] > distance[now.start] + now.time) {
                    return true;
                }
            }
        }
        return false;
    }
}
