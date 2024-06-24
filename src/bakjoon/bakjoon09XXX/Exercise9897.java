package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise9897 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        boolean[] light = new boolean[l+1];
        Map<String, int[]> guard = new LinkedHashMap<>();
        for (int i = 0; i < g; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            guard.put(name, new int[] {a, d});
        }

        for (int i = 0; i < r; i++) {
            String onCall = br.readLine();
            if (guard.containsKey(onCall)) {
                int a = guard.get(onCall)[0];
                int d = guard.get(onCall)[1];
                for (int j = a; j <= l; j += d) {
                    light[j] = !light[j];
                }
            }
        }

        int count = 0;
        for (int i = 0; i <= l; i++) {
            count += light[i] ? 1 : 0;
        }
        System.out.println(count);
    }
}
