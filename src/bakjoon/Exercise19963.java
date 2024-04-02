package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise19963 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Set<Integer> bunch1 = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            bunch1.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> bunch2 = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            bunch2.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (bunch1.contains(i) || bunch2.contains(i)) {
                continue;
            }
            sb.append(i).append(" ");
        }
        System.out.println(n-m-k);
        System.out.println(sb);
    }
}
