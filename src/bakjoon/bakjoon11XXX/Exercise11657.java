package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise11657 {
    private static class Edge {
        int start, end;
        long weight;
        public Edge(int start, int end, long weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    private static final List<Edge> edges = new ArrayList<>();
    public static long[] distance;
    public static final long INF = 1000000000;
    public static int nodeCount, edgeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());

        distance = new long[nodeCount+1];
        Arrays.fill(distance, INF);
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, weight));
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (!bellmanFord(1)) {
            for (int i = 2; i < nodeCount+1; i++) {
                bw.write((distance[i] != INF ? distance[i] : -1)+"\n");
            }
        } else {
            bw.write(-1+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static boolean bellmanFord(int start) {
        distance[start] = 0;
        for (int i = 1; i < nodeCount; i++) {
            for (Edge now : edges) {
                if (distance[now.start] != INF && distance[now.end] > distance[now.start]+now.weight) {
                    distance[now.end] = distance[now.start]+now.weight;
                }
            }
        }
        for (Edge now : edges) {
            if (distance[now.start] != INF && distance[now.end] > distance[now.start]+now.weight) {
                return true;
            }
        }
        return false;
    }
}
