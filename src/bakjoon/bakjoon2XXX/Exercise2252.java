package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise2252 {
    private static final Map<Integer, List<Integer>> graph = new LinkedHashMap<>();
    private static int[] entryLevel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int studentCount = Integer.parseInt(st.nextToken());
        int compCount = Integer.parseInt(st.nextToken());
        entryLevel = new int[studentCount+1];
        for (int i = 1; i <= studentCount; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < compCount; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            entryLevel[back]++;
            graph.get(front).add(back);
        }
        br.close();

        System.out.println(topologicalSort(studentCount));
    }

    public static String topologicalSort(int studentCount) {
        List<String> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= studentCount; i++) {
            if (entryLevel[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            result.add(now.toString());
            for (Integer next : graph.get(now)) {
                entryLevel[next]--;
                if (entryLevel[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return String.join(" ", result);
    }
}
