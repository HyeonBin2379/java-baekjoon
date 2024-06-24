package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise2251 {
    private static final int[] now = new int[3];
    private static final int[][] sendingCase = {{0,1}, {0,2}, {1,0}, {1,2}, {2,0}, {2,1}};
    private static final boolean[][] visited = new boolean[201][201];
    private static final boolean[] answer = new boolean[201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < now.length; i++) {
            now[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        bfs();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                bw.write(i+" ");
            }
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

    public static void bfs() {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{0, 0});
        visited[0][0] = true;
        answer[now[2]] = true;

        while (!queue.isEmpty()) {
            Integer[] nowNode = queue.poll();
            int A = nowNode[0];
            int B = nowNode[1];
            int C = now[2] - A - B;

            for (int[] nextNode : sendingCase) {
                Integer[] next = {A, B, C};
                int sender = nextNode[0];
                int receiver = nextNode[1];

                next[receiver] += next[sender];
                next[sender] = 0;
                if (next[receiver] > now[receiver]) {
                    next[sender] += next[receiver] - now[receiver];
                    next[receiver] = now[receiver];
                }
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new Integer[]{next[0], next[1]});
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
}
