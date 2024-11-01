package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise30646 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Long, List<Integer>> numByIndex = new TreeMap<>(Comparator.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] prefixSum = new long[n+1];
        for (int i = 1; i < prefixSum.length; i++) {
            long num = Long.parseLong(st.nextToken());
            numByIndex.putIfAbsent(num, new ArrayList<>());
            numByIndex.get(num).add(i);
            prefixSum[i] = prefixSum[i-1] + num;
        }

        Map<Long, Integer> count = new TreeMap<>();
        long max = 0;
        for (List<Integer> indexList : numByIndex.values()) {
            int end = indexList.get(indexList.size()-1);
            int start = indexList.get(0);
            long sum = prefixSum[end]-prefixSum[start-1];
            max = Math.max(max, sum);
            count.merge(sum, 1, Integer::sum);
        }
        System.out.println(max + " " + count.get(max));
    }
}
