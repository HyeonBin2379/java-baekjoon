package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise30794 {
    private static final Map<String, Integer> judgeTable = new HashMap<>(
            Map.of(
                    "miss", 0,
                    "bad", 200,
                    "cool", 400,
                    "great", 600,
                    "perfect", 1000
            )
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int level = Integer.parseInt(st.nextToken());
        String judgement = st.nextToken();
        System.out.println(Integer.valueOf(level * judgeTable.get(judgement)));
    }
}
