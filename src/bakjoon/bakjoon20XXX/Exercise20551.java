package bakjoon.bakjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise20551 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);

        Map<Integer, Integer> sorted = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (!sorted.containsKey(array[i])) {
                sorted.put(array[i], i);
            }
        }
        for (int i = 0; i < q; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(sorted.getOrDefault(num, -1));
        }
    }
}
