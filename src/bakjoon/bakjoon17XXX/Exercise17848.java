package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise17848 {

    private static int[] assignedSeat;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken())-1;
        assignedSeat = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)-1).toArray();
        visited = new boolean[n];
        bfs(m);
    }

    private static void bfs(int now) {
        int count = 0;
        while (!visited[now] && assignedSeat[now] != now) {
            visited[now] = true;
            count++;
            now = assignedSeat[now];
        }
        System.out.println(count);
    }
}
