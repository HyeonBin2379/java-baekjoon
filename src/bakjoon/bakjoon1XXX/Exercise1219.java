package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise1219 {
    private static class Edge {
        int start, end;
        long cost;
        public Edge(int start, int end, long cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    private static final List<Edge> edges = new ArrayList<>();
    public static long[] distance, cityMoney;
    public static int nodeCount, start, end, edgeCount;
    public static final long MIN = Long.MIN_VALUE;
    public static final long MAX = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            edges.add(new Edge(from, to, cost));
        }

        st = new StringTokenizer(br.readLine());
        cityMoney = new long[nodeCount];
        distance = new long[nodeCount];
        Arrays.fill(distance, MIN);
        for (int i = 0; i < nodeCount; i++) {
            cityMoney[i] = Long.parseLong(st.nextToken());
        }
        br.close();

        bellmanFord(start, end);
    }

    public static void bellmanFord(int start, int dest) {
        distance[start] = cityMoney[start];

        for (int i = 0; i < nodeCount+100; i++) {
            for (Edge now : edges) {
                if (distance[now.start] == MIN) {
                    continue;
                }
                if (distance[now.start] == MAX) {
                    distance[now.end] = MAX;
                } else if (distance[now.end] < distance[now.start]+cityMoney[now.end]-now.cost) {
                    distance[now.end] = distance[now.start]+cityMoney[now.end]-now.cost;
                    if (i >= nodeCount-1) {
                        distance[now.end] = MAX;
                    }
                }
            }
        }

        if (distance[dest] == MIN) {
            System.out.println("gg");
        } else if (distance[dest] == MAX) {
            System.out.println("Gee");
        } else {
            System.out.println(distance[dest]);
        }
    }
}
