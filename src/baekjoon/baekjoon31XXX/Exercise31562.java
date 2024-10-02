package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise31562 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> song = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            StringBuilder melody = new StringBuilder();

            for (int j = 0; j < 7; j++) {
                melody.append(st.nextToken());
            }
            song.put(name, melody.toString());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            StringBuilder input = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                input.append(st.nextToken());
            }
            int count = 0;
            String answer = "";
            for (String name : song.keySet()) {
                if (song.get(name).startsWith(input.toString())) {
                    answer = (count > 0) ? "?" : name;
                    count++;
                }
            }
            System.out.println(count == 0 ? "!" : answer);
        }
    }
}
