package bakjoon.bakjoon30XXX;

import java.io.*;
import java.util.*;

public class Exercise30019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer[]> using = new LinkedHashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int room = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (i == 0) {
                using.put(room, new Integer[] {start, end});
                bw.write("YES\n");
                continue;
            }

            if (!using.containsKey(room) || using.get(room)[1] <= start) {
                using.put(room, new Integer[] {start, end});
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
