package programmers;

class VisitingDistanceSolution {
    private final boolean[][][] visited = new boolean[11][11][4];
    private final int[][] moves = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int solution(String dirs) {
        int answer = 0;
        int[] prev = {5, 5};

        for (char c : dirs.toCharArray()) {
            int direction = -1;
            switch (c) {
                case 'U' -> direction = 0;
                case 'L' -> direction = 1;
                case 'R' -> direction = 2;
                case 'D' -> direction = 3;
            }

            int[] next = {prev[0]+moves[direction][0], prev[1]+moves[direction][1]};

            if (next[0] < 0 || next[0] > 10 || next[1] < 0 || next[1] > 10) {
                continue;
            }

            if (!visited[next[0]][next[1]][3-direction] && !visited[next[0]][next[1]][direction]) {
                visited[next[0]][next[1]][direction] = true;
                visited[next[0]][next[1]][3-direction] = true;
                answer++;
            }
            prev = next.clone();
        }
        return answer;
    }
}

public class VisitingDistance {
    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        System.out.println(new VisitingDistanceSolution().solution(dirs));
    }
}
