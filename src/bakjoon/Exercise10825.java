package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Exercise10825 {
    private static class Score {
        int kor, eng, math;
        public Score(int kor, int eng, int math) {
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }
    private static final Map<String, Score> scoreTable = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            scoreTable.put(name, new Score(kor, eng, math));
        }
        br.close();

        List<Entry<String, Score>> sorted = new ArrayList<>(scoreTable.entrySet());
        sorted.sort((o1, o2) -> {
            if (o1.getValue().kor != o2.getValue().kor) {
                return o2.getValue().kor - o1.getValue().kor;
            } else if (o1.getValue().eng != o2.getValue().eng) {
                return o1.getValue().eng - o2.getValue().eng;
            } else if (o1.getValue().math != o2.getValue().math) {
                return o2.getValue().math - o1.getValue().math;
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Score> entry : sorted) {
            sb.append(entry.getKey()).append("\n");
        }
        System.out.print(sb);
    }
}
