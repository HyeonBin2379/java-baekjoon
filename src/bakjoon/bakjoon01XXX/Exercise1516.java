package bakjoon.bakjoon01XXX;

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

public class Exercise1516 {
    private static final Map<Integer, List<Integer>> techTree = new LinkedHashMap<>();
    private static int[] selfBuild, inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int buildingCount = Integer.parseInt(br.readLine());

        selfBuild = new int[buildingCount+1];
        inDegree = new int[buildingCount+1];

        for (int i = 1; i < buildingCount+1; i++) {
            techTree.put(i, new ArrayList<>());
        }
        for (int i = 1; i < buildingCount+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int prevNum = Integer.parseInt(st.nextToken());
                if (prevNum == -1) {
                    break;
                }
                techTree.get(prevNum).add(i);
                inDegree[i]++;
            }
        }
        br.close();

        topologicalSort(buildingCount);
    }

    public static void topologicalSort(int buildingCount) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= buildingCount; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[buildingCount+1];
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (Integer next : techTree.get(now)) {
                inDegree[next]--;
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < buildingCount+1; i++) {
            sb.append(result[i] + selfBuild[i]).append("\n");
        }
        System.out.print(sb);
    }
}
