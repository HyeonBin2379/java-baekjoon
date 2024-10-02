package baekjoon.baekjoon17XXX;

import java.io.*;
import java.util.*;

public class Exercise17472 {
    static class Edge implements Comparable<Edge>{
        int from, to, value;
        public Edge(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }

    }
    static int n,m, islandCnt;
    static int[][] map;
    static int[] parents;
    static Queue<int[]> q;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static boolean[][] check;
    static int[][] move = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        islandCnt = 2;
        check = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]==1 && !check[i][j]) {
                    islandIndexing(j, i, islandCnt);
                    islandCnt++;
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]!=0) {
                    makeBridge(j, i, map[i][j]);
                }
            }
        }

        islandCnt--;
        parents = new int[islandCnt];
        for(int i=1; i<islandCnt; i++) {
            parents[i] = i;
        }
        int answer = shortestPath();
        System.out.println(answer == 0 ? -1 : answer);

    }

    static void islandIndexing(int x, int y, int idx) {
        q = new LinkedList<>();

        q.add(new int[] {x,y});
        map[y][x] = idx;
        check[y][x] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int[] nextMove : move) {
                int nx = now[0] + nextMove[0];
                int ny = now[1] + nextMove[1];

                if(nx<0 || ny <0 || nx > m-1 || ny > n-1 || check[ny][nx]) continue;

                if(map[ny][nx]==1) {
                    map[ny][nx] = idx;
                    check[ny][nx] = true;
                    q.add(new int[] {nx,ny});
                }
            }
        }
    }

    static void makeBridge(int x, int y, int idx) {
        q = new LinkedList<>();
        check = new boolean[n][m];
        for(int[] nextMove : move) {
            q.add(new int[] {x,y,0});
            check[y][x] = true;

            while(!q.isEmpty()) {
                int[] now = q.poll();
                int nx = now[0] + nextMove[0];
                int ny = now[1] + nextMove[1];
                int move = now[2];

                if(nx<0 || ny <0 || nx > m-1 || ny > n-1 || check[ny][nx]) continue;

                if(map[ny][nx]!=idx) {
                    if(map[ny][nx] !=0) {
                        int from = idx-1;
                        int to = map[ny][nx]-1;
                        if(move > 1) {
                            pq.add(new Edge(from, to, move));
                            pq.add(new Edge(to, from, move));
                            break;
                        }
                    }else {
                        check[ny][nx] = true;
                        q.add(new int[] {nx, ny, move+1});
                    }
                }
            }
            q.clear();
        }
    }

    static int shortestPath() {
        int sum = 0;
        int size = pq.size();
        for(int i=0; i< size; i++) {
            Edge edge = pq.poll();
            assert edge != null;
            if(find(edge.from) != find(edge.to)) {
                sum += edge.value;
                union(edge.from, edge.to);
            }
        }

        int root = parents[1];
        for(int i=2; i<islandCnt; i++) {
            if(root != find(parents[i])) {
                return 0;
            }
        }
        return sum;
    }

    static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parents[x] = Math.min(x, y);
            parents[y] = parents[x];
        }
    }
}