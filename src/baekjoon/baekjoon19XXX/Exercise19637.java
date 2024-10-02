package baekjoon.baekjoon19XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise19637 {

    private static class Power implements Comparable<Power> {
        String title;
        int limit;

        public Power(String title, int limit) {
            this.title = title;
            this.limit = limit;
        }

        @Override
        public int compareTo(Power o) {
            return this.limit-o.limit;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Power> grade = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String title = st.nextToken();
            int limit = Integer.parseInt(st.nextToken());
            grade.add(new Power(title, limit));
        }
        Collections.sort(grade);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());
            int start = 0;
            int end = n-1;
            while (start <= end) {
                int mid = (start+end)/2;
                if (power > grade.get(mid).limit) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
            bw.write(grade.get(start).title + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
