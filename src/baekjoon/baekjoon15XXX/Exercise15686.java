package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise15686 {

    private static int n, m;
    private static int ANSWER = Integer.MAX_VALUE;
    private static boolean[] opened;

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static final List<Node> home = new ArrayList<>();
    private static final List<Node> chicken = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                switch (map[i][j]) {
                    case 1 -> home.add(new Node(i, j));
                    case 2 -> chicken.add(new Node(i, j));
                }
            }
        }

        opened = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(ANSWER);
    }

    private static void dfs(int start, int count) {
        if (count == m) {
            int result = home.stream().mapToInt(person -> getMinDistance(person)).sum();
            ANSWER = Math.min(result, ANSWER);
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            opened[i] = true;
            dfs(i+1, count+1);
            opened[i] = false;
        }
    }

    private static int getMinDistance(Node person) {
        return IntStream.rangeClosed(0, chicken.size()-1)
                .filter(i -> opened[i])
                .map(i -> getDistance(person, chicken.get(i)))
                .min()
                .getAsInt();
    }
    private static int getDistance(Node home, Node chicken) {
        return Math.abs(home.x-chicken.x) + Math.abs(home.y-chicken.y);
    }
}
