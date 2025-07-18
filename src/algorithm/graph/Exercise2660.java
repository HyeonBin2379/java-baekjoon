package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise2660 {

    static class Member {
        int num, score;

        public Member(int num, int score) {
            this.num = num;
            this.score = score;
        }
    }

    private static final List<List<Integer>> graph = new ArrayList<>();
    private static final PriorityQueue<Member> pq = new PriorityQueue<>(
            (o1, o2) -> o1.score != o2.score
            ? Integer.compare(o1.score, o2.score)
            : Integer.compare(o1.num, o2.num));

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) {
                break;
            }
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }
        System.out.println(pq.peek().score + " " + getCount());
        pq.stream().filter(member -> member.score == pq.peek().score)
                .map(member -> member.num)
                .sorted()
                .forEach(num -> System.out.print(num + " "));
    }

    private static void bfs(int start) {
        Queue<Member> queue = new LinkedList<>();
        queue.offer(new Member(start, 0));
        visited[start] = true;

        int totalScore = 0;
        while (!queue.isEmpty()) {
            Member cur = queue.poll();
            totalScore = Math.max(totalScore, cur.score);

            for (int next : graph.get(cur.num)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Member(next, cur.score+1));
                }
            }
        }
        pq.add(new Member(start, totalScore));
    }

    private static int getCount() {
        int min = pq.peek().score;
        return (int) pq.stream().filter(member -> member.score == min).count();
    }
}
