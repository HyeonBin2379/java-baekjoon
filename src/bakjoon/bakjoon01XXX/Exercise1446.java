package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise1446 {

    private static int[] dist;
    private static final int INF = 1000000000;
    private static final List<List<Spot>> graph = new ArrayList<>();
    private static class Spot implements Comparable<Spot> {
        int loc, distance;

        public Spot(int loc, int distance) {
            this.loc = loc;             // 현재 지점
            this.distance = distance;   // 현 지점까지의 총 이동 거리
        }

        @Override
        public int compareTo(Spot o) {
            return this.distance-o.distance;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        setGraph();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Spot(to, weight));
        }
        dijkstra(d);
    }

    private static void setGraph() {
        dist = new int[10001];
        IntStream.rangeClosed(0, 10000).forEach(i -> {
            graph.add(new ArrayList<>());
            dist[i] = INF;
        });
    }

    // 다익스트라 + 배낭문제 응용
    private static void dijkstra(int d) {
        // 특정 지점에서의 총 이동거리의 최솟값을 우선 선택
        PriorityQueue<Spot> queue = new PriorityQueue<>();

        // d: 세준이가 주행할 고속도로의 길이
        // 길이 d에 도달하기 위한 총 이동 거리의 최솟값 연산
        for (int i = 0; i <= d; i++) {
            // 1. 현 지점까지의 총 이동거리의 최솟값 갱신
            dist[i] = (i > 0) ? Math.min(dist[i-1]+1, dist[i]) : 0;

            // 2-1. 현 지점에서 이용 가능한 지름길이 없는 경우
            if (graph.get(i).isEmpty()) {
                continue;
            }

            // 2-2. 이용 가능한 지름길 존재: 본격적인 다익스트라 알고리즘 전개
            queue.add(new Spot(i, dist[i]));
            while (!queue.isEmpty()) {
                Spot now = queue.poll();

                // 3-1. 이전에 통과했던 지점인지 확인
                if (now.distance > dist[now.loc]) {
                    continue;
                }
                // 3-2. 도달한 적 없는 지점인 경우: 이용 가능한 지름길의 길이의 최솟값을 총 이동거리에 합산
                for (Spot next : graph.get(now.loc)) {
                    int cost = now.distance + next.distance;

                    // 지름길 이용으로 고속도로 내부에서의 이동 거리를 단축한 경우
                    if (next.loc <= d && dist[next.loc] > cost) {
                        dist[next.loc] = cost;
                        queue.add(new Spot(next.loc, cost));
                    }
                }
            }
        }
        // 4. 고속도로의 끝 지점 도착 시 이동 거리의 최소값 출력
        System.out.println(dist[d]);
    }
}
