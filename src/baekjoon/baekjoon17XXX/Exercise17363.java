package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise17363 {

    private static final Map<Character, Character> letter = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        char[][] fallen = new char[r][c];
        setLetter();
        for (int i = 0; i < c; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < r; j++) {
                fallen[j][i] = letter.get(input[j]);
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = r-1; i >= 0; i--) {
            for (int j = 0; j < c; j++) {
                answer.append(fallen[i][j]);
            }
            answer.append("\n");
        }
        System.out.print(answer);
    }

    private static void setLetter() {
        letter.put('.', '.');
        letter.put('O', 'O');
        letter.put('-', '|');
        letter.put('|', '-');
        letter.put('/', '\\');
        letter.put('\\', '/');
        letter.put('^', '<');
        letter.put('<', 'v');
        letter.put('v', '>');
        letter.put('>', '^');
    }
}
