package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise31428 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> countByTrack = new HashMap<>();
        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            String track = st.nextToken();
            countByTrack.put(track, countByTrack.getOrDefault(track, 0)+1);
        }
        String myTrack = br.readLine();
        System.out.println(countByTrack.getOrDefault(myTrack, 0));
        br.close();
    }
}
