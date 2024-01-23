package programmers;

import java.util.ArrayList;
import java.util.List;

class SheepAndWolfSolution {
    private int sheep, wolf;
    private final List<List<Integer>> graph = new ArrayList<>();

    public int solution(int[] info, int[][] edges) {
        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        return dfs(0, new ArrayList<>(graph.get(0)), info);
    }

    public int dfs(int currPos, List<Integer> nextDepth, int[] info) {
        if (info[currPos] == 0) {
            sheep++;
        } else {
            wolf++;
        }

        int answer = sheep;
        if (sheep <= wolf) {
            return answer;
        }
        for (int i = 0; i < nextDepth.size(); i++) {
            Integer next = nextDepth.get(i);
            List<Integer> stackNodes = new ArrayList<>(nextDepth);

            stackNodes.remove(next);
            stackNodes.addAll(graph.get(next));
            answer = Math.max(answer, dfs(next, stackNodes, info));
            if (info[next] == 0) {
                sheep--;
            } else {
                wolf--;
            }
        }
        return answer;
    }
}
public class SheepAndWolf {
    public static void main(String[] args) {
        int[] info = {0,1,0,1,1,0,1,0,0,1,0};
        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};
        System.out.println(new SheepAndWolfSolution().solution(info, edges));
    }
}
