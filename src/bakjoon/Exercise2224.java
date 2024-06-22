package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise2224 {

    private static final boolean[][] logic = new boolean[58][58];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        setLogic();
        for (int i = 0; i < n; i++) {
            int[] prop = Arrays.stream(br.readLine().split(" => ")).mapToInt(s -> s.charAt(0)-'A').toArray();
            if (prop[0] == prop[1] || logic[prop[0]][prop[1]]) {
                continue;
            }
            logic[prop[0]][prop[1]] = true;
        }

        for (int k = 0; k < logic.length; k++) {
            for (int i = 0; i < logic.length; i++) {
                for (int j = 0; j < logic.length; j++) {
                    if (logic[i][j] || i == j) {
                        continue;
                    }
                    logic[i][j] = logic[i][k] && logic[k][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < logic.length; i++) {
            for (int j = 0; j < logic.length; j++) {
                if (!logic[i][j] || i == j) {
                    continue;
                }
                answer.add(String.format("%c => %c\n", (char)('A' + i), (char)('A' + j)));
            }
        }
        sb.append(answer.size()).append("\n");
        answer.forEach(sb::append);
        System.out.print(sb);
    }

    private static void setLogic() {
        for (int i = 0; i < logic.length; i++) {
            logic[i][i] = true;
        }
    }
}
