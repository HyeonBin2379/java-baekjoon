package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Exercise9019 {
    private static final String[] dslr = {"D", "S", "L", "R"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            Integer[] number = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            bw.write(bfs(number[0], number[1]) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static String bfs(Integer start, Integer end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        String[] command = new String[10000];
        Arrays.fill(command, "");

        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty() && !visited[end]) {
            Integer now = queue.poll();
            Integer[] nextMove = {doubleNum(now), subtractNum(now), leftRotateNum(now), rightRotateNum(now)};

            for (int i = 0; i < nextMove.length; i++) {
                if (!visited[nextMove[i]]) {
                    queue.offer(nextMove[i]);
                    visited[nextMove[i]] = true;
                    command[nextMove[i]] = command[now] + dslr[i];
                }
            }
        }
        return command[end];
    }

    private static Integer doubleNum(int num) {
        return (2 * num) % 10000;
    }
    private static Integer subtractNum(int num) {
        return (num == 0) ? 9999 : num-1;
    }
    private static Integer leftRotateNum(int num) {
        return (num % 1000) * 10 + (num / 1000);
    }
    private static Integer rightRotateNum(int num) {
        return (num % 10) * 1000 + (num / 10);
    }
}
