package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10709 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[][] input = new char[h][w];
        for (int i = 0; i < h; i++) {
            input[i] = br.readLine().toCharArray();
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < h; i++) {
            boolean hasCloud = input[i][0] == 'c';
            answer.append(hasCloud ? 0 : -1).append(" ");
            int count = 0;
            for (int j = 1; j < w; j++) {
                if (input[i][j] == '.') {
                    answer.append(hasCloud ? ++count : -1).append(" ");
                } else {
                    hasCloud = true;
                    count = 0;
                    answer.append(count).append(" ");
                }
            }
            answer.append("\n");
        }
        System.out.print(answer);
    }
}
