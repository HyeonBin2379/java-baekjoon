package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise9742 {

    private static int num, time;
    private static String[] original, temp;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            original = st.nextToken().split("");
            num = Integer.parseInt(st.nextToken());
            time = 0;

            temp = new String[original.length];
            visited = new boolean[original.length];
            int fact = IntStream.rangeClosed(1, original.length).reduce(1, (a,b) -> a*b);
            if (fact < num) {
                System.out.printf("%s %d = %s\n", String.join("", original), num, "No permutation");
            } else {
                findAnswer(0);
            }
        }
    }

    private static void findAnswer(int lenCnt) {
        if (lenCnt == original.length) {
            time++;
            if (time == num) {
                System.out.printf("%s %d = %s\n", String.join("", original), num, String.join("", temp));
            }
            return;
        }

        for (int i = 0; i < original.length; i++) {
            if (!visited[i]) {
                temp[lenCnt] = original[i];
                visited[i] = true;
                findAnswer(lenCnt+1);
                visited[i] = false;
            }
        }
    }
}
