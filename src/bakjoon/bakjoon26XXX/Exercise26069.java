package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int meetLogCount = Integer.parseInt(br.readLine());
        Set<String> dance = new HashSet<>();
        dance.add("ChongChong");
        for (int i = 0; i < meetLogCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String nameA = st.nextToken();
            String nameB = st.nextToken();
            if (!dance.contains(nameA) && !dance.contains(nameB)) {
                continue;
            }
            dance.add(nameA);
            dance.add(nameB);
        }
        br.close();
        System.out.println(dance.size());
    }
}
