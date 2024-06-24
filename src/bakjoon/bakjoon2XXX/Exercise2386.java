package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2386 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String letter = st.nextToken();
            if (letter.equals("#")) {
                break;
            }
            int count = 0;
            while (st.hasMoreTokens()) {
                count += (int) st.nextToken().toLowerCase()
                        .chars()
                        .filter(value -> (char)value == letter.charAt(0))
                        .count();
            }
            sb.append(letter).append(" ").append(count).append("\n");
        }
        System.out.print(sb);
    }
}
