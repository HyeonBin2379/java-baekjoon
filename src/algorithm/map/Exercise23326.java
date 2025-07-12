package algorithm.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise23326 {

    private static final TreeSet<Integer> landmark = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                landmark.add(i);
            }
        }

        int now = 1;
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());

            switch (query) {
                case 1 -> {
                    int num = Integer.parseInt(st.nextToken());
                    if (landmark.contains(num)) {
                        landmark.remove(num);
                    } else {
                        landmark.add(num);
                    }
                }
                case 2 -> {
                    int hop = Integer.parseInt(st.nextToken());
                    now = (now+hop) % n;
                    if (now == 0) {
                        now = n;
                    }
                }
                case 3 -> System.out.println(needMove(now, n));
            }
        }
    }

    private static int needMove(int cur, int n) {
        Integer ceiling = landmark.ceiling(cur);

        if (ceiling != null) {
            return ceiling-cur;
        }
        return landmark.isEmpty() ? -1 : n-cur+landmark.first();
    }
}
