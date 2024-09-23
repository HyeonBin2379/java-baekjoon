package bakjoon.bakjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise32280 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> attended = new ArrayList<>();
        String teacher = "";
        for (int i = 0; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String time = st.nextToken();
            String type = st.nextToken();
            if (type.equals("teacher")) {
                teacher = time;
            } else {
                attended.add(time);
            }
        }
        String timeLimit = br.readLine();
        attended.sort(null);

        int t_idx = n, late_idx = n;
        for (int i = 0; i < n; i++) {
            if (attended.get(i).compareTo(teacher) >= 0) {
                t_idx = Math.min(i, t_idx);
            }
            if (attended.get(i).compareTo(timeLimit) >= 0) {
                late_idx = Math.min(i, late_idx);
            }
        }
        if (late_idx <= t_idx) {
            System.out.println(n-t_idx);
        } else {
            System.out.println(n-late_idx);
        }
    }
}
