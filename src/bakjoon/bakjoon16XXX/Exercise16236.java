package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Exercise16236 {

    private static int size;
    private static int[][] sea, dist;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final PriorityQueue<Info> smallFish = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        sea = new int[size][size];
        dist = new int[size][size];

        Integer[] pos = new Integer[] {0, 0};
        for (int i = 0; i < size; i++) {
            sea[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < size; j++) {
                if (sea[i][j] == 9) {
                    pos[0] = i;
                    pos[1] = j;
                    sea[i][j] = 0;
                }
            }
        }

        int answer = 0;
        int sharkSize = 2;
        int count = 0;
        while (true) {
            bfs(pos, sharkSize);
            if (smallFish.isEmpty()) {
                break;
            }

            Info fish = smallFish.poll();
            answer += fish.distance;
            pos = new Integer[] {fish.r, fish.c};
            sea[pos[0]][pos[1]] = 0;

            count++;
            if (sharkSize == count) {
                sharkSize++;
                count = 0;
            }
        }
        System.out.println(answer);
    }

    private static void initDist() {
        for (int i = 0; i < size; i++) {
            Arrays.fill(dist[i], -1);
        }
    }

    private static void bfs(Integer[] pos, int sharkSize) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(pos.clone());

        initDist();
        dist[pos[0]][pos[1]] = 0;
        smallFish.clear();

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nextR = now[0] + ints[0];
                int nextC = now[1] + ints[1];

                // 지도 범위를 벗어난 경우
                if (nextR < 0 || nextR >= size || nextC < 0 || nextC >= size) {
                    continue;
                }
                // 상어보다 큰 물고기가 있는 칸인 경우
                if (sea[nextR][nextC] > sharkSize || dist[nextR][nextC] != -1) {
                    continue;
                }
                // 지나갈 수 있는 칸 또는 상어보다 작은 물고기가 있는 칸
                if (sea[nextR][nextC] == 0 || sea[nextR][nextC] <= sharkSize) {
                    dist[nextR][nextC] = dist[now[0]][now[1]] + 1;
                    queue.add(new Integer[]{nextR, nextC});

                    // 상어가 먹을 수 있는 물고기
                    if (sea[nextR][nextC] < sharkSize && sea[nextR][nextC] >= 1) {
                        smallFish.add(new Info(nextR, nextC, dist[nextR][nextC]));
                    }
                }
            }
        }
    }

    private static class Info implements Comparable<Info> {
        int r, c, distance;

        public Info(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }

        @Override
        public int compareTo(Info o) {
            if (this.distance == o.distance) {
                return (this.r == o.r) ? Integer.compare(this.c, o.c) : Integer.compare(this.r, o.r);
            }
            return Integer.compare(this.distance, o.distance);
        }
    }
}
