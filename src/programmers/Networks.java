package programmers;

class NetworksSolution {
    private boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                bfs(computers, n, i);
            }
        }
        return answer;
    }

    public void bfs(int[][] computers, int n, int from) {
        visited[from] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && computers[from][i] == 1) {
                bfs(computers, n, i);
            }
        }
    }
}
public class Networks {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new NetworksSolution().solution(n, computers));
    }
}