package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise14467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Boolean> isRight = new TreeMap<>();
        int testCase = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            boolean right = Integer.parseInt(st.nextToken()) == 1;
            if (!isRight.containsKey(cow)) {
                isRight.put(cow, right);
                continue;
            }
            if (isRight.get(cow) != right) {
                isRight.put(cow, right);
                count++;
            }
        }
        System.out.println(count);
    }
}
