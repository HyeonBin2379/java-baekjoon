package bakjoon.bakjoon7XXX;

import java.io.*;
import java.util.*;

public class Exercise7132 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Double> count = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        for (int i = m; i <= n; i++) {
            for (int j = m; j <= n; j++) {
                count.add((double)i/j);
            }
        }
        System.out.println(count.size());
    }
}
